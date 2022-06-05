package ir.hamidrezaamz.data.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tbl_news_source")
data class NewsSourceEntity(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: String,

    @ColumnInfo(name = "name")
    val name: String?,

    @ColumnInfo(name = "description")
    val description: String?,

    @ColumnInfo(name = "url")
    val url: String?,

    @ColumnInfo(name = "category")
    val category: String?,

    @ColumnInfo(name = "language")
    val language: String?,

    @ColumnInfo(name = "country")
    val country: String?
)