package ir.hamidrezaamz.data.apiservice

import ir.hamidrezaamz.data.apimodels.NewsSourceResponseModel
import ir.hamidrezaamz.data.apimodels.NewsTopHeadlinesResponseModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApiService {

    @GET("/v2/top-headlines/sources")
    suspend fun getNewsSourceList(@Query("apiKey") apiKey: String): Response<NewsSourceResponseModel>

    @GET("/v2/top-headlines")
    suspend fun getNewsTopHeadlinesList(@Query("sources") sourceId: String, @Query("apiKey") apiKey: String): Response<NewsTopHeadlinesResponseModel>

}