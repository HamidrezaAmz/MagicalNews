package ir.hamidrezaamz.domain.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ir.hamidrezaamz.domain.repository.DataRepositoryImpl
import ir.hamidrezaamz.domain.usecases.NewsAgencyListUseCase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ApplicationModule {

    @Singleton
    @Provides
    fun provideDataRepository() = DataRepositoryImpl()

    @Singleton
    @Provides
    fun provideNewsAgencyList(repo: DataRepositoryImpl) = NewsAgencyListUseCase(repo)

}