package ir.hamidrezaamz.domain.repository.local

import ir.hamidrezaamz.data.db.dao.NewsSourceDao
import ir.hamidrezaamz.data.db.entity.NewsSourceEntity
import javax.inject.Inject

class LocalDataSource @Inject constructor(
    private val newsSourceDao: NewsSourceDao
) {

    fun getNewsSourceList(): List<NewsSourceEntity> {
        return newsSourceDao.getAll()
    }

}