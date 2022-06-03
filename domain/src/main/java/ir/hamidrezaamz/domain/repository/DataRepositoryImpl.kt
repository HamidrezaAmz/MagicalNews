package ir.hamidrezaamz.domain.repository

import ir.hamidrezaamz.domain.models.NewsAgencyModel

class DataRepositoryImpl : DataRepository {

    override fun getNewsAgencyList(): List<NewsAgencyModel> {
        return listOf()
    }

    override fun getNewsAgencyDetail(): NewsAgencyModel {
        return NewsAgencyModel(-1, "NO NAME")
    }

}