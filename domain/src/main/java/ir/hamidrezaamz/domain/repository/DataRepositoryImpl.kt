package ir.hamidrezaamz.domain.repository

import ir.hamidrezaamz.data.db.entity.NewsArticleEntity
import ir.hamidrezaamz.data.db.entity.NewsSourceEntity
import ir.hamidrezaamz.data.mappers.NewsArticleMapper
import ir.hamidrezaamz.data.mappers.NewsSourceMapper
import ir.hamidrezaamz.domain.repository.local.LocalDataSource
import ir.hamidrezaamz.domain.repository.remote.RemoteDataSource
import ir.hamidrezaamz.domain.repository.remote.base.ApiResult
import ir.hamidrezaamz.domain.repository.remote.base.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class DataRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
) : DataRepository {

    // TODO: This scenario show be change with RX Single (HAMIDREZA)
    override suspend fun getNewsSourceList(): Flow<Resource<List<NewsSourceEntity>>> = flow {
        emit(Resource.Loading())

        val newsSourceEntityList = localDataSource.getNewsSourceList()
        emit(Resource.Loading(data = newsSourceEntityList))

        try {
            val apiResult = remoteDataSource.getNewsSourceList()
            if (apiResult.apiStatus == ApiResult.ApiStatus.SUCCESS) {
                apiResult.data?.sources?.let {
                    localDataSource.addNewsSourceList(it.map { _newsSourceModel ->
                        NewsSourceMapper.toNewsSourceEntity(_newsSourceModel)
                    })
                }
            }
        } catch (e: HttpException) {
            emit(
                Resource.Error(
                    message = "Oops, something went wrong!",
                    data = newsSourceEntityList
                )
            )
        } catch (e: IOException) {
            emit(
                Resource.Error(
                    message = "Couldn't reach server, check your internet connection.",
                    data = newsSourceEntityList
                )
            )
        }

        emit(Resource.Success(data = localDataSource.getNewsSourceList()))
    }

    // TODO: This scenario show be change with RX Single (HAMIDREZA)
    override suspend fun getNewsTopHeadlinesList(sourceId: String): Flow<Resource<List<NewsArticleEntity>>> =
        flow {
            emit(Resource.Loading())

            val newsArticleEntityList = localDataSource.getNewsArticleList(sourceId)
            emit(Resource.Loading(data = newsArticleEntityList))

            try {
                val apiResult = remoteDataSource.getNewsTopHeadlinesList(sourceId)
                if (apiResult.apiStatus == ApiResult.ApiStatus.SUCCESS) {
                    apiResult.data?.articles?.let {
                        localDataSource.addNewsArticleList(
                            it
                                .map { _newsSourceModel ->
                                    NewsArticleMapper.toNewsArticleEntity(_newsSourceModel)
                                })
                    }
                }
            } catch (e: HttpException) {
                emit(
                    Resource.Error(
                        message = "Oops, something went wrong!",
                        data = newsArticleEntityList
                    )
                )
            } catch (e: IOException) {
                emit(
                    Resource.Error(
                        message = "Couldn't reach server, check your internet connection.",
                        data = newsArticleEntityList
                    )
                )
            }

            emit(Resource.Success(data = localDataSource.getNewsArticleList(sourceId)))
        }

}