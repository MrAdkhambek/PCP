package mr.adkhambek.pcp.dialog

import android.app.Dialog
import android.content.Context
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import mr.adkhambek.pcp.R
import mr.adkhambek.pcp.ktx.editFlow
import mr.adkhambek.pcp.model.Country
import mr.adkhambek.pcp.model.Data
import mr.adkhambek.pcp.model.PcpModel
import kotlin.coroutines.resume


internal class FullScreenDialog(
    private val language: String, context: Context,
    private val listener: CountryAdapter.Listener
) : Dialog(context, R.style.FullScreenDialog),
    CoroutineScope by CoroutineScope(Dispatchers.Main) {

    private var recyclerView: RecyclerView? = null
    private var countryAdapter: CountryAdapter? = null

    init {
        val contentView: View = View.inflate(context, R.layout.dialog_full_screen, null)
        setContentView(contentView)

        countryAdapter = CountryAdapter(object : CountryAdapter.Listener {
            override fun onSelectCountry(country: Country) {
                listener.onSelectCountry(country)
                dismiss()
            }
        })

        recyclerView = contentView.findViewById(R.id.recycler)
        recyclerView?.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = countryAdapter
        }

        val cancelButton = contentView.findViewById<TextView>(R.id.cancel_button)
        cancelButton.setOnClickListener { dismiss() }

        val editText = contentView.findViewById<EditText>(R.id.edit_text)
        var data: Data? = null

        editText
            .editFlow()
            .onStart {
                data = fetchModel().data
                editText.hint = data?.messages?.get("hint_search")
                cancelButton.text = data?.messages?.get("title_cancel")
                emit("")
            }.map { name ->
                if (name.isEmpty()) data?.countries?.country
                else data?.countries?.country?.filter { country ->
                    country.name.startsWith(name, true) || country.phoneCode.startsWith(name, true)
                }
            }.onEach { countries ->
                countryAdapter?.submitList(countries ?: arrayListOf())
            }.launchIn(this)
    }

    private suspend fun fetchModel() = suspendCancellableCoroutine<PcpModel> { cont ->
        val data = Gson().fromJson<PcpModel>(context.assets.open("${language}.json").bufferedReader(), PcpModel::class.java)
        cont.resume(data)
    }

    override fun dismiss() {
        coroutineContext.cancel()
        recyclerView?.adapter = null
        countryAdapter = null
        recyclerView = null
        super.dismiss()
    }
}