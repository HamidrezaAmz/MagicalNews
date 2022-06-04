package ir.hamidrezaamz.domain.repository

import ir.hamidrezaamz.data.apimodels.NewsSourceResponseModel
import ir.hamidrezaamz.data.apimodels.NewsTopHeadlinesResponseModel
import ir.hamidrezaamz.domain.repository.remote.RemoteDataSource
import ir.hamidrezaamz.domain.repository.remote.base.ApiResult
import javax.inject.Inject

class DataRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource
    // local data source is loading ...
) : DataRepository {

    override suspend fun getNewsSourceList(): ApiResult<NewsSourceResponseModel> {
        return remoteDataSource.getNewsSourceList()
    }

    override suspend fun getNewsTopHeadlinesList(sourceId: String): ApiResult<NewsTopHeadlinesResponseModel> {
        return remoteDataSource.getNewsTopHeadlinesList(sourceId = sourceId)
    }

}