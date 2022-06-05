package ir.hamidrezaAmz.magicalnews.view.adapter.viewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import ir.hamidrezaAmz.magicalnews.R
import ir.hamidrezaAmz.magicalnews.model.extras.PublicFunction.Companion.getDisplayLanguage
import ir.hamidrezaAmz.magicalnews.view.myInterfaces.RecyclerViewListCallback
import ir.hamidrezaamz.data.db.entity.NewsSourceEntity

class NewsSourceViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.recyclerview_news_source_list_item, parent, false)) {

    private var textViewTitle: AppCompatTextView? = null
    private var textViewDescription: AppCompatTextView? = null
    private var textViewCategory: AppCompatTextView? = null
    private var textViewLanguage: AppCompatTextView? = null

    init {
        textViewTitle = itemView.findViewById(R.id.appCompatTextView_title)
        textViewDescription = itemView.findViewById(R.id.appCompatTextView_description)
        textViewCategory = itemView.findViewById(R.id.appCompatTextView_category)
        textViewLanguage = itemView.findViewById(R.id.appCompatTextView_language)
    }

    fun bind(newsSourceEntity: NewsSourceEntity, recyclerViewListCallback: RecyclerViewListCallback?) {
        textViewTitle?.text = newsSourceEntity.name
        textViewCategory?.text = newsSourceEntity.category
        textViewLanguage?.text = getDisplayLanguage(newsSourceEntity.language)
        textViewDescription?.text = newsSourceEntity.description

        itemView.setOnClickListener { _itemView ->
            recyclerViewListCallback?.onItemClicked(newsSourceEntity)
        }
    }

}