package ir.hamidrezaamz.domain.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ir.hamidrezaamz.data.apiservice.NewsApiService
import ir.hamidrezaamz.domain.repository.DataRepositoryImpl
import ir.hamidrezaamz.domain.repository.local.LocalDataSource
import ir.hamidrezaamz.domain.repository.local.dao.NewsArticleDao
import ir.hamidrezaamz.domain.repository.local.dao.NewsSourceDao
import ir.hamidrezaamz.domain.repository.remote.RemoteDataSource
import ir.hamidrezaamz.domain.usecases.NewsSourceListUseCase
import ir.hamidrezaamz.domain.usecases.NewsTopHeadlineListUseCase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ApplicationModule {

    @Singleton
    @Provides
    fun provideNewsSourceListUseCase(repo: DataRepositoryImpl) = NewsSourceListUseCase(repo)

    @Singleton
    @Provides
    fun provideNewsTopHeadlinesUseCase(repo: DataRepositoryImpl) = NewsTopHeadlineListUseCase(repo)

    @Singleton
    @Provides
    fun provideDataRepository(remoteDataSource: RemoteDataSource, localDataSource: LocalDataSource) =
        DataRepositoryImpl(
            remoteDataSource = remoteDataSource,
            localDataSource = localDataSource
        )

    @Singleton
    @Provides
    fun provideRemoteDataSource(newsApiService: NewsApiService) = RemoteDataSource(newsApiService)

    @Singleton
    @Provides
    fun provideLocalDataSource(newsSourceDao: NewsSourceDao, newsArticleDao: NewsArticleDao) =
        LocalDataSource(newsSourceDao, newsArticleDao)

}