package ir.hamidrezaamz.domain.repository

import ir.hamidrezaamz.data.db.entity.NewsArticleEntity
import ir.hamidrezaamz.data.db.entity.NewsSourceEntity
import ir.hamidrezaamz.domain.repository.remote.base.Resource
import kotlinx.coroutines.flow.Flow

interface DataRepository {

    suspend fun getNewsSourceList(): Flow<Resource<List<NewsSourceEntity>>>

    suspend fun getNewsTopHeadlinesList(sourceId: String): Flow<Resource<List<NewsArticleEntity>>>

}