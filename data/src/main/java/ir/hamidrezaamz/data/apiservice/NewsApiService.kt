package ir.hamidrezaamz.data.apiservice

import ir.hamidrezaamz.data.apimodels.NewsArticlesResponseModel
import ir.hamidrezaamz.data.apimodels.NewsSourceResponseModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApiService {

    @GET("/v2/top-headlines/sources")
    suspend fun getNewsSourceList(@Query("apiKey") apiKey: String): Response<NewsSourceResponseModel>

    @GET("v2/everything")
    suspend fun getNewsList(@Query("q") query: String, @Query("apiKey") apiKey: String): Response<NewsArticlesResponseModel>

}