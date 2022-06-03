package ir.hamidrezaamz.domain.usecases

import ir.hamidrezaamz.domain.models.NewsModel
import ir.hamidrezaamz.domain.repository.DataRepositoryImpl
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class NewsListUseCase(
    private val repo: DataRepositoryImpl,
    private val defaultDispatcher: CoroutineDispatcher = Dispatchers.Default
) {

    suspend operator fun invoke(): List<NewsModel> = withContext(defaultDispatcher) {
        repo.getNewsList()
    }

}