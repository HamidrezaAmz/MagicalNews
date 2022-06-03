package ir.hamidrezaamz.domain.repository

import ir.hamidrezaamz.data.apimodels.NewsArticlesResponseModel
import ir.hamidrezaamz.data.apimodels.NewsSourceResponseModel
import ir.hamidrezaamz.domain.models.NewsModel
import ir.hamidrezaamz.domain.repository.remote.base.ApiResult

interface DataRepository {

    suspend fun getNewsSourceList(): ApiResult<NewsSourceResponseModel>

    suspend fun getNewsList(): ApiResult<NewsArticlesResponseModel>

    suspend fun getNewsDetail(): NewsModel

}