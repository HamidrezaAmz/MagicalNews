package ir.hamidrezaAmz.magicalnews.view.adapter.viewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import ir.hamidrezaAmz.magicalnews.R
import ir.hamidrezaAmz.magicalnews.view.myInterfaces.RecyclerViewListCallback
import ir.hamidrezaamz.data.apimodels.NewsSourceModel

class NewsSourceViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.recyclerview_news_source_list_item, parent, false)) {

    private var textViewTitle: AppCompatTextView? = null
    private var textViewDescription: AppCompatTextView? = null

    init {
        textViewTitle = itemView.findViewById(R.id.appCompatTextView_title)
        textViewDescription = itemView.findViewById(R.id.appCompatTextView_description)
    }

    fun bind(newsSourceModel: NewsSourceModel, recyclerViewListCallback: RecyclerViewListCallback?) {
        textViewTitle?.text = newsSourceModel.name
        textViewDescription?.text = newsSourceModel.description

        itemView.setOnClickListener { _itemView ->
            recyclerViewListCallback?.onItemClicked(newsSourceModel)
        }
    }

}