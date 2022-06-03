package ir.hamidrezaamz.domain.repository

import ir.hamidrezaamz.data.apimodels.NewsResponseModel
import ir.hamidrezaamz.domain.models.NewsModel
import ir.hamidrezaamz.domain.repository.remote.base.ApiResult

interface DataRepository {

    suspend fun getNewsList(): ApiResult<NewsResponseModel>

    fun getNewsDetail(): NewsModel

}