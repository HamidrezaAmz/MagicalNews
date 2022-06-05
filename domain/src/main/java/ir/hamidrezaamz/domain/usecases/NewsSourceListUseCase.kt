package ir.hamidrezaamz.domain.usecases

import ir.hamidrezaamz.data.db.entity.NewsSourceEntity
import ir.hamidrezaamz.domain.repository.DataRepositoryImpl
import ir.hamidrezaamz.domain.repository.remote.base.Resource
import kotlinx.coroutines.flow.Flow

class NewsSourceListUseCase(
    private val repo: DataRepositoryImpl,
) {

    suspend operator fun invoke(): Flow<Resource<List<NewsSourceEntity>>> {
        return repo.getNewsSourceList()
    }

}