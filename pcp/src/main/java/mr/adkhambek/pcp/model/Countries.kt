package mr.adkhambek.pcp.model


import com.google.gson.annotations.SerializedName


data class Countries(

    @SerializedName("country")
    val country: List<Country>
)