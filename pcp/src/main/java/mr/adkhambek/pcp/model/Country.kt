package mr.adkhambek.pcp.model


import com.google.gson.annotations.SerializedName

data class Country(

    @SerializedName("english_name")
    val englishName: String,

    @SerializedName("name")
    val name: String,

    @SerializedName("name_code")
    val nameCode: String,

    @SerializedName("phone_code")
    val phoneCode: String
)