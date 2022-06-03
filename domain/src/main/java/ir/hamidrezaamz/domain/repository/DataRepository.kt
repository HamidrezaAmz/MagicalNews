package ir.hamidrezaamz.domain.repository

import ir.hamidrezaamz.domain.models.NewsAgencyModel

interface DataRepository {

    fun getNewsAgencyList(): List<NewsAgencyModel>

    fun getNewsAgencyDetail(): NewsAgencyModel

}