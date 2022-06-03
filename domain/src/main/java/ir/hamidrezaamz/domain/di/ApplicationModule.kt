package ir.hamidrezaamz.domain.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ir.hamidrezaamz.data.apiservice.NewsApiService
import ir.hamidrezaamz.data.extras.PublicValue
import ir.hamidrezaamz.domain.repository.DataRepositoryImpl
import ir.hamidrezaamz.domain.repository.remote.RemoteDataSource
import ir.hamidrezaamz.domain.usecases.NewsSourceListUseCase
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ApplicationModule {

    @Singleton
    @Provides
    fun provideNewsAgencyList(repo: DataRepositoryImpl) = NewsSourceListUseCase(repo)

    @Singleton
    @Provides
    fun provideDataRepository(remoteDataSource: RemoteDataSource) =
        DataRepositoryImpl(remoteDataSource)

    @Singleton
    @Provides
    fun provideRemoteDataSource(newsApiService: NewsApiService) =
        RemoteDataSource(newsApiService)

    @Singleton
    @Provides
    fun provideNewsApiService(retrofit: Retrofit): NewsApiService =
        retrofit.create(NewsApiService::class.java)

    @Singleton
    @Provides
    fun provideRetrofit(gson: Gson): Retrofit = Retrofit.Builder()
        .baseUrl(PublicValue.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()

    @Singleton
    @Provides
    fun provideGson(): Gson {
        return GsonBuilder()
            .setLenient()
            .create()
    }
}