package ir.hamidrezaamz.domain.repository

import ir.hamidrezaamz.data.apimodels.NewsSourceResponseModel
import ir.hamidrezaamz.data.apimodels.NewsTopHeadlinesResponseModel
import ir.hamidrezaamz.domain.repository.remote.base.ApiResult

interface DataRepository {

    suspend fun getNewsSourceList(): ApiResult<NewsSourceResponseModel>

    suspend fun getNewsTopHeadlinesList(sourceId: String): ApiResult<NewsTopHeadlinesResponseModel>

}