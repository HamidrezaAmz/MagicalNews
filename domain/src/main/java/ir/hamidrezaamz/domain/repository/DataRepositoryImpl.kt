package ir.hamidrezaamz.domain.repository

import ir.hamidrezaamz.data.apimodels.NewsResponseModel
import ir.hamidrezaamz.domain.models.NewsModel
import ir.hamidrezaamz.domain.repository.remote.RemoteDataSource
import ir.hamidrezaamz.domain.repository.remote.base.ApiResult
import javax.inject.Inject

class DataRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource
    // local data source is loading ...
) : DataRepository {

    override suspend fun getNewsList(): ApiResult<NewsResponseModel> {
        return remoteDataSource.getNewsList()
    }

    override fun getNewsDetail(): NewsModel {
        return NewsModel(-1, "NO NAME")
    }

}