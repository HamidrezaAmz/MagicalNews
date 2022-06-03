package ir.hamidrezaamz.domain.usecases

import ir.hamidrezaamz.domain.models.NewsAgencyModel
import ir.hamidrezaamz.domain.repository.DataRepositoryImpl
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class NewsAgencyListUseCase(
    private val repo: DataRepositoryImpl,
    private val defaultDispatcher: CoroutineDispatcher = Dispatchers.Default
) {

    suspend operator fun invoke(): List<NewsAgencyModel> = withContext(defaultDispatcher) {
        repo.getNewsAgencyList()
    }

}