package mr.adkhambek.pcp

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.core.view.isVisible
import mr.adkhambek.pcp.dialog.CountryAdapter
import mr.adkhambek.pcp.dialog.FullScreenDialog
import mr.adkhambek.pcp.ktx.getFlagMasterResID
import mr.adkhambek.pcp.model.Country
import java.util.*


class PcpView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayoutCompat(context, attrs, defStyleAttr) {

    init {
        init(context, attrs)
    }

    private lateinit var pcpArrow: ImageView
    private lateinit var pcpImageView: ImageView
    private lateinit var pcpCodeTextView: TextView

    private var isHideCountryName = false

    private lateinit var selectedCountry: Country

    val value: String
        get() = selectedCountry.phoneCode

    private fun init(context: Context, attrs: AttributeSet?) {
        LayoutInflater.from(context).inflate(R.layout.layout_pcp, this)
        gravity = Gravity.CENTER_VERTICAL

        pcpArrow = findViewById(R.id.pcp_arrow)
        pcpImageView = findViewById(R.id.pcp_image)
        pcpCodeTextView = findViewById(R.id.pcp_code)

        setOnClickListener {
            showFullScreenDialog()
        }

        val attributes: TypedArray = context.obtainStyledAttributes(attrs, R.styleable.PcpView, 0, 0)

        try {
            pcpArrow.isVisible = !attributes.getBoolean(R.styleable.PcpView_hideArrow, false)
            pcpImageView.isVisible = !attributes.getBoolean(R.styleable.PcpView_hideFlag, false)
            isHideCountryName = attributes.getBoolean(R.styleable.PcpView_hideCountryName, false)

        } catch (e: Exception) {
            Log.e("PcpView", e.message ?: e.localizedMessage ?: "Error")
        } finally {
            attributes.recycle()
            setSelectCountry(Country("Uzbekistan", "O'zbekiston", "uz", "998"))
        }
    }

    @SuppressLint("DefaultLocale")
    private fun showFullScreenDialog() {
        FullScreenDialog(detectLanguage(), context, object : CountryAdapter.Listener {
            override fun onSelectCountry(country: Country) {
                setSelectCountry(country)
            }
        }).show()
    }

    private fun setSelectCountry(country: Country) {
        selectedCountry = country
        pcpImageView.setImageResource(getFlagMasterResID(country))

        pcpCodeTextView.text = if (isHideCountryName) String.format("+%s", country.phoneCode)
        else String.format("%s +%s", country.nameCode.toUpperCase(), country.phoneCode)
    }

    private fun detectLanguage(): String {
        val locale = Locale.getDefault()
        return when {
            locale.language.equals(SUPPORTED_LANGUAGES[0], true) -> SUPPORTED_LANGUAGES[0]
            locale.language.equals(SUPPORTED_LANGUAGES[1], true) -> SUPPORTED_LANGUAGES[1]
            else -> SUPPORTED_LANGUAGES[2]
        }
    }

    companion object {

        @JvmField
        val SUPPORTED_LANGUAGES = arrayOf("uz", "ru", "en")
    }
}