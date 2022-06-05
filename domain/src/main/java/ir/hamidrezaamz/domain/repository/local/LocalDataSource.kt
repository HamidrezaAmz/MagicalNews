package ir.hamidrezaamz.domain.repository.local

import ir.hamidrezaamz.data.db.entity.NewsArticleEntity
import ir.hamidrezaamz.data.db.entity.NewsSourceEntity
import ir.hamidrezaamz.domain.repository.local.dao.NewsArticleDao
import ir.hamidrezaamz.domain.repository.local.dao.NewsSourceDao
import javax.inject.Inject

class LocalDataSource @Inject constructor(
    private val newsSourceDao: NewsSourceDao,
    private val newsArticleDao: NewsArticleDao
) {

    fun getNewsSourceList(): List<NewsSourceEntity> {
        return newsSourceDao.getAll()
    }

    fun addNewsSourceList(newsSourceList: List<NewsSourceEntity>) {
        newsSourceDao.insertAll(newsSourceList)
    }

    fun getNewsArticleList(sourceId : String): List<NewsArticleEntity> {
        return newsArticleDao.getAllById(sourceId)
    }

    fun addNewsArticleList(newsArticleEntity: List<NewsArticleEntity>) {
        newsArticleDao.insertAll(newsArticleEntity)
    }

}