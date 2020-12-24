package mr.adkhambek.pcp.dialog

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import mr.adkhambek.pcp.R
import mr.adkhambek.pcp.ktx.getFlagMasterResID
import mr.adkhambek.pcp.model.Country


internal class CountryAdapter(
    private val listener: Listener
) : ListAdapter<Country, CountryAdapter.CountryVH>(DiffUtilCallback) {

    companion object DiffUtilCallback : DiffUtil.ItemCallback<Country>() {
        override fun areContentsTheSame(oldItem: Country, newItem: Country): Boolean = oldItem == newItem
        override fun areItemsTheSame(oldItem: Country, newItem: Country): Boolean = oldItem.nameCode == newItem.nameCode
    }

    internal interface Listener {
        fun onSelectCountry(country: Country)
    }

    inner class CountryVH(view: View) : RecyclerView.ViewHolder(view) {
        private val phoneCode = view.findViewById<TextView>(R.id.phone_code)
        private val flagImage = view.findViewById<ImageView>(R.id.flag_image)
        private val countryName = view.findViewById<TextView>(R.id.country_name)

        init {
            view.setOnClickListener {
                listener.onSelectCountry(getItem(adapterPosition))
            }
        }

        @SuppressLint("DefaultLocale")
        fun onBind() {
            val item = getItem(adapterPosition)

            flagImage.setImageResource(getFlagMasterResID(item))
            phoneCode.text = String.format("+%s", item.phoneCode)
            countryName.text = String.format("%s (%s)", item.name, item.nameCode.toUpperCase())
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryVH {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_country, parent, false)
        return CountryVH(view)
    }

    override fun onBindViewHolder(holder: CountryVH, position: Int) = holder.onBind()
}