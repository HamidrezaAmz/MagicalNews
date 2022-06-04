package ir.hamidrezaAmz.magicalnews.view.adapter.viewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import ir.hamidrezaAmz.magicalnews.R
import ir.hamidrezaAmz.magicalnews.view.myInterfaces.RecyclerViewListCallback
import ir.hamidrezaamz.data.apimodels.NewsArticleModel

class NewsTopHeadlineViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.recyclerview_news_top_headline_list_item, parent, false)) {

    private var imageViewCover: AppCompatImageView? = null
    private var textViewTitle: AppCompatTextView? = null
    private var textViewDescription: AppCompatTextView? = null

    init {
        imageViewCover = itemView.findViewById(R.id.appCompatImageView_cover)
        textViewTitle = itemView.findViewById(R.id.appCompatTextView_title)
        textViewDescription = itemView.findViewById(R.id.appCompatTextView_description)
    }

    fun bind(newsArticleModel: NewsArticleModel, recyclerViewListCallback: RecyclerViewListCallback?) {

        imageViewCover?.let { _imageViewCover ->
            Glide.with(itemView)
                .load(newsArticleModel.urlToImage)
                .centerCrop()
                .into(_imageViewCover)
        }

        textViewTitle?.let { _textViewTitle ->
            _textViewTitle.text = newsArticleModel.title
        }

        textViewDescription?.let { _textViewDescription ->
            _textViewDescription.text = newsArticleModel.description
        }

        itemView.setOnClickListener { _itemView ->
            recyclerViewListCallback?.onItemClicked(newsArticleModel)
        }
    }

}