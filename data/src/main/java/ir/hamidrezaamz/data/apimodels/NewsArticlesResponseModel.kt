package ir.hamidrezaamz.data.apimodels

import com.google.gson.annotations.SerializedName

data class NewsArticlesResponseModel(
    @SerializedName("status")
    var status: String,
    @SerializedName("totalResults")
    var totalResults: Int,
    @SerializedName("articles")
    var articles: List<Any>
)