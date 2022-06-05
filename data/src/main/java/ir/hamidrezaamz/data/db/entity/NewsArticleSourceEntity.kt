package ir.hamidrezaamz.data.db.entity

import androidx.room.ColumnInfo

data class NewsArticleSourceEntity(
    @ColumnInfo(name = "id")
    val id: String,

    @ColumnInfo(name = "name")
    val name: String
)