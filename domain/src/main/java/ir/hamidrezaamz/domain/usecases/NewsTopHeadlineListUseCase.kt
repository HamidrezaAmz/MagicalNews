package ir.hamidrezaamz.domain.usecases

import ir.hamidrezaamz.data.db.entity.NewsArticleEntity
import ir.hamidrezaamz.domain.repository.DataRepositoryImpl
import ir.hamidrezaamz.domain.repository.remote.base.Resource
import kotlinx.coroutines.flow.Flow

class NewsTopHeadlineListUseCase(
    private val repo: DataRepositoryImpl,
) {

    suspend operator fun invoke(sourceId: String): Flow<Resource<List<NewsArticleEntity>>> {
        return repo.getNewsTopHeadlinesList(sourceId = sourceId)
    }

}