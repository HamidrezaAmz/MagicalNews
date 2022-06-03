package ir.hamidrezaamz.domain.repository.remote

import android.util.Log
import ir.hamidrezaamz.data.apiservice.NewsApiService
import ir.hamidrezaamz.data.extras.PublicValue
import ir.hamidrezaamz.domain.models.NewsModel
import javax.inject.Inject

class RemoteDataSource @Inject constructor(
    private val newsApiService: NewsApiService
) {

    suspend fun getNewsList(): List<NewsModel> {
        val response = newsApiService.getNewsList("BITCOIN", PublicValue.API_KEY)

        Log.i("TAG", "getNewsList: $response")

        return listOf<NewsModel>()
    }

}