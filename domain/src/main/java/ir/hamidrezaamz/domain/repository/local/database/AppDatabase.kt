package ir.hamidrezaamz.domain.repository.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import ir.hamidrezaamz.data.db.entity.NewsArticleEntity
import ir.hamidrezaamz.data.db.entity.NewsSourceEntity
import ir.hamidrezaamz.data.extras.PublicValue.Companion.KEY_DATABASE_VERSION
import ir.hamidrezaamz.domain.repository.local.dao.NewsArticleDao
import ir.hamidrezaamz.domain.repository.local.dao.NewsSourceDao

@Database(entities = [NewsSourceEntity::class, NewsArticleEntity::class], version = KEY_DATABASE_VERSION, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun newsSourceDao(): NewsSourceDao
    abstract fun newsArticleDao(): NewsArticleDao
}