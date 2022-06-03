package ir.hamidrezaamz.domain.repository

import ir.hamidrezaamz.domain.models.NewsModel
import ir.hamidrezaamz.domain.repository.remote.RemoteDataSource
import javax.inject.Inject

class DataRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource
    // local data source is loading ...
) : DataRepository {

    override suspend fun getNewsList(): List<NewsModel> {
        return remoteDataSource.getNewsList()
    }

    override fun getNewsDetail(): NewsModel {
        return NewsModel(-1, "NO NAME")
    }

}