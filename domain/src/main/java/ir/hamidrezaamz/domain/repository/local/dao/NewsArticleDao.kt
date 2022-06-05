package ir.hamidrezaamz.domain.repository.local.dao

import androidx.room.*
import ir.hamidrezaamz.data.db.entity.NewsArticleEntity

@Dao
interface NewsArticleDao {

    @Query("SELECT * FROM tbl_news_article")
    fun getAll(): List<NewsArticleEntity>

    @Query("SELECT * FROM tbl_news_article WHERE id=:sourceId")
    fun getAllById(sourceId: String): List<NewsArticleEntity>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertAll(newsArticleEntityList: List<NewsArticleEntity>): LongArray

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(newsArticleEntity: NewsArticleEntity): Long

    @Delete
    fun delete(newsArticleEntity: NewsArticleEntity)

}