package ir.hamidrezaamz.domain.repository

import ir.hamidrezaamz.domain.models.NewsModel

interface DataRepository {

    suspend fun getNewsList(): List<NewsModel>

    fun getNewsDetail(): NewsModel

}