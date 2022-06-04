package ir.hamidrezaamz.data.apimodels

import com.google.gson.annotations.SerializedName

data class NewsArticleSourceModel(
    @SerializedName("id")
    val id: String?,
    @SerializedName("name")
    val name: String?,
)