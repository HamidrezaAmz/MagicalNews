package ir.hamidrezaamz.domain.repository.remote

import ir.hamidrezaamz.data.apiservice.NewsApiService
import ir.hamidrezaamz.data.extras.PublicValue
import ir.hamidrezaamz.domain.repository.remote.base.BaseDataSource
import javax.inject.Inject

class RemoteDataSource @Inject constructor(
    private val newsApiService: NewsApiService
) : BaseDataSource() {

    suspend fun getNewsList() = getResult {
        newsApiService.getNewsList("BITCOIN", PublicValue.API_KEY)
    }

}