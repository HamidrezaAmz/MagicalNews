package ir.hamidrezaamz.domain.repository

import android.util.Log
import ir.hamidrezaamz.data.apimodels.NewsSourceResponseModel
import ir.hamidrezaamz.data.apimodels.NewsTopHeadlinesResponseModel
import ir.hamidrezaamz.domain.repository.local.LocalDataSource
import ir.hamidrezaamz.domain.repository.remote.RemoteDataSource
import ir.hamidrezaamz.domain.repository.remote.base.ApiResult
import javax.inject.Inject

class DataRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
) : DataRepository {

    override suspend fun getNewsSourceList(): ApiResult<NewsSourceResponseModel> {

        // get data from remote source

        // get data from local source

        // combine them and then return! ;)

        val items = localDataSource.getNewsSourceList()
        Log.i("TAG", "getNewsSourceList: ========================================")
        Log.i("TAG", "getNewsSourceList: size -> ${items.size}")

        return remoteDataSource.getNewsSourceList()
    }

    override suspend fun getNewsTopHeadlinesList(sourceId: String): ApiResult<NewsTopHeadlinesResponseModel> {
        return remoteDataSource.getNewsTopHeadlinesList(sourceId = sourceId)
    }

}