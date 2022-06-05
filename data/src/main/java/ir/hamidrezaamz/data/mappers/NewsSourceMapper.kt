package ir.hamidrezaamz.data.mappers

import ir.hamidrezaamz.data.apimodels.NewsSourceModel
import ir.hamidrezaamz.data.db.entity.NewsSourceEntity

object NewsSourceMapper {

    fun toNewsSourceEntity(newsSourceModel: NewsSourceModel): NewsSourceEntity {
        return NewsSourceEntity(
            newsSourceModel.id ?: "",
            newsSourceModel.name ?: "",
            newsSourceModel.description ?: "",
            newsSourceModel.url ?: "",
            newsSourceModel.category ?: "",
            newsSourceModel.language ?: "",
            newsSourceModel.country ?: ""
        )
    }

}