package ir.hamidrezaamz.domain.repository.remote

import ir.hamidrezaamz.data.apiservice.NewsApiService
import ir.hamidrezaamz.data.extras.PublicValue
import ir.hamidrezaamz.domain.repository.remote.base.BaseDataSource
import javax.inject.Inject

class RemoteDataSource @Inject constructor(
    private val newsApiService: NewsApiService
) : BaseDataSource() {

    suspend fun getNewsSourceList() = getResult {
        newsApiService.getNewsSourceList(apiKey = PublicValue.API_KEY)
    }

    suspend fun getNewsTopHeadlinesList(sourceId: String) = getResult {
        newsApiService.getNewsTopHeadlinesList(sourceId = sourceId, apiKey = PublicValue.API_KEY)
    }

}