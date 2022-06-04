package ir.hamidrezaamz.domain.repository.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import ir.hamidrezaamz.data.db.dao.NewsSourceDao
import ir.hamidrezaamz.data.db.entity.NewsSourceEntity
import ir.hamidrezaamz.data.extras.PublicValue.Companion.KEY_DATABASE_VERSION

@Database(entities = [NewsSourceEntity::class], version = KEY_DATABASE_VERSION, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun newsSourceDao(): NewsSourceDao
}