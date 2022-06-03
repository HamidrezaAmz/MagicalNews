package ir.hamidrezaamz.domain.usecases

import ir.hamidrezaamz.data.apimodels.NewsResponseModel
import ir.hamidrezaamz.domain.repository.DataRepositoryImpl
import ir.hamidrezaamz.domain.repository.remote.base.ApiResult
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class NewsListUseCase(
    private val repo: DataRepositoryImpl,
    private val defaultDispatcher: CoroutineDispatcher = Dispatchers.Default
) {

    suspend operator fun invoke(): ApiResult<NewsResponseModel> = withContext(defaultDispatcher) {
        repo.getNewsList()
    }

}