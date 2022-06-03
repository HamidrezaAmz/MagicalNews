package ir.hamidrezaamz.data.apiservice

import ir.hamidrezaamz.data.apimodels.NewsResponseModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApiService {

    @GET("v2/everything")
    suspend fun getNewsList(@Query("q") query: String, @Query("apiKey") apiKey: String): Response<NewsResponseModel>

}