package ir.hamidrezaamz.data.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import ir.hamidrezaamz.data.db.entity.NewsSourceEntity

@Dao
interface NewsSourceDao {

    @Query("SELECT * FROM tbl_news_source")
    fun getAll(): List<NewsSourceEntity>

    @Insert
    fun insertAll(newsSourceEntity: NewsSourceEntity)

    @Delete
    fun delete(newsSourceEntity: NewsSourceEntity)

}