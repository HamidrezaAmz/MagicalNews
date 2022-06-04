package ir.hamidrezaamz.domain.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import ir.hamidrezaamz.data.extras.PublicValue.Companion.KEY_DATABASE_NAME
import ir.hamidrezaamz.domain.repository.local.database.AppDatabase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext app: Context) = Room.databaseBuilder(
        app,
        AppDatabase::class.java,
        KEY_DATABASE_NAME
    ).build()

    @Singleton
    @Provides
    fun provideNewsSourceDao(db: AppDatabase) = db.newsSourceDao()

}