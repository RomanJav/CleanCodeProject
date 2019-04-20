package by.tomal.cleancodeproject.data.entity

import com.google.gson.annotations.SerializedName

data class VehicleResponse(
    @SerializedName("poiList")
    val poiList: List<VehiclePoiResponse>? = null
)