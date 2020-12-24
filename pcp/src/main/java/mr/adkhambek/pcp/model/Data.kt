package mr.adkhambek.pcp.model


import com.google.gson.annotations.SerializedName

data class Data(

    @SerializedName("countries")
    val countries: Countries,

    @SerializedName("messages")
    val messages: Map<String, String>
)