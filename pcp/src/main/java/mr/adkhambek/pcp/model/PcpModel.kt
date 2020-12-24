package mr.adkhambek.pcp.model


import com.google.gson.annotations.SerializedName


data class PcpModel(

    @SerializedName("data")
    val data: Data
)