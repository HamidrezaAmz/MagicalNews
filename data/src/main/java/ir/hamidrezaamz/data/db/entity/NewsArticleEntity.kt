package ir.hamidrezaamz.data.db.entity

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tbl_news_article")
data class NewsArticleEntity(

    @Embedded val source: NewsArticleSourceEntity,

    @ColumnInfo(name = "author")
    val author: String?,

    @ColumnInfo(name = "title:")
    val title: String?,

    @ColumnInfo(name = "description")
    val description: String?,

    @ColumnInfo(name = "url")
    val url: String?,

    @ColumnInfo(name = "urlToImage")
    val urlToImage: String?,

    @ColumnInfo(name = "publishedAt")
    val publishedAt: String?,

    @ColumnInfo(name = "content")
    val content: String?,
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "newsArticleId")
    var newsArticleId: Int = 0
}