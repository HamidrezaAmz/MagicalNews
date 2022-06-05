package ir.hamidrezaamz.domain.repository.local.dao

import androidx.room.*
import ir.hamidrezaamz.data.db.entity.NewsSourceEntity

@Dao
interface NewsSourceDao {

    @Query("SELECT * FROM tbl_news_source")
    fun getAll(): List<NewsSourceEntity>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertAll(newsSourceEntityList: List<NewsSourceEntity>): LongArray

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(newsSourceEntity: NewsSourceEntity): Long

    @Delete
    fun delete(newsSourceEntity: NewsSourceEntity)

}