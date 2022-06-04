package ir.hamidrezaamz.data.apimodels

import com.google.gson.annotations.SerializedName

data class NewsSourceResponseModel(
    @SerializedName("status")
    var status: String,
    @SerializedName("sources")
    var sources: List<NewsSourceModel>
)