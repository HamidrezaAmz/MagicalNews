package ir.hamidrezaamz.domain.repository

import ir.hamidrezaamz.data.apimodels.NewsArticlesResponseModel
import ir.hamidrezaamz.data.apimodels.NewsSourceResponseModel
import ir.hamidrezaamz.domain.models.NewsModel
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

    override suspend fun getNewsList(): ApiResult<NewsArticlesResponseModel> {
        return remoteDataSource.getNewsList()
    }

    override suspend fun getNewsDetail(): NewsModel {
        return NewsModel(-1, "NO NAME")
    }

}