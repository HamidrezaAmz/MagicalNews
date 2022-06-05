package ir.hamidrezaamz.data.mappers

import ir.hamidrezaamz.data.apimodels.NewsArticleModel
import ir.hamidrezaamz.data.apimodels.NewsArticleSourceModel
import ir.hamidrezaamz.data.db.entity.NewsArticleEntity
import ir.hamidrezaamz.data.db.entity.NewsArticleSourceEntity

object NewsArticleMapper {

    fun toNewsArticleEntity(newsArticleModel: NewsArticleModel): NewsArticleEntity {
        return NewsArticleEntity(
            toNewsArticleSourceEntity(newsArticleModel.source),
            newsArticleModel.author ?: "",
            newsArticleModel.title ?: "",
            newsArticleModel.description ?: "",
            newsArticleModel.url ?: "",
            newsArticleModel.urlToImage ?: "",
            newsArticleModel.publishedAt ?: "",
            newsArticleModel.content ?: "",
        )
    }

    private fun toNewsArticleSourceEntity(newsArticleSourceModel: NewsArticleSourceModel?): NewsArticleSourceEntity {
        return NewsArticleSourceEntity(
            newsArticleSourceModel?.id ?: "INVALID ID",
            newsArticleSourceModel?.name ?: "INVALID NAME"
        )
    }

}