package mr.adkhambek.pcp

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.view.Gravity
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.LinearLayoutCompat
import mr.adkhambek.pcp.dialog.CountryAdapter
import mr.adkhambek.pcp.dialog.FullScreenDialog
import mr.adkhambek.pcp.ktx.getFlagMasterResID
import mr.adkhambek.pcp.model.Country


class PcpView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayoutCompat(context, attrs, defStyleAttr) {

    init {
        init(context)
    }

    private lateinit var flagImageView: ImageView
    private lateinit var phoneCodeTextView: TextView

    private var selectedCountry: Country = Country("Uzbekistan", "O'zbekiston", "uz", "998")
    val value: String
        get() = selectedCountry.phoneCode

    private fun init(context: Context) {
        LayoutInflater.from(context).inflate(R.layout.layout_pcp, this)
        gravity = Gravity.CENTER_VERTICAL

        flagImageView = findViewById(R.id.flag_image)
        phoneCodeTextView = findViewById(R.id.phone_code)

        setOnClickListener {
            showFullScreenDialog()
        }
    }

    @SuppressLint("DefaultLocale")
    private fun showFullScreenDialog() {
        FullScreenDialog(SUPPORTED_LANGUAGES[0], context, object : CountryAdapter.Listener {
            override fun onSelectCountry(country: Country) {
                selectedCountry = country
                flagImageView.setImageResource(getFlagMasterResID(country))
                phoneCodeTextView.text = String.format("%s +%s", country.nameCode.toUpperCase(), country.phoneCode)
            }
        }).show()
    }

    companion object {

        @JvmField
        val SUPPORTED_LANGUAGES = arrayOf("uz")
    }
}