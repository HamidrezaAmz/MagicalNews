package ir.hamidrezaAmz.magicalnews.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ir.hamidrezaAmz.magicalnews.view.adapter.viewholder.NewsTopHeadlineViewHolder
import ir.hamidrezaAmz.magicalnews.view.myInterfaces.RecyclerViewListCallback
import ir.hamidrezaamz.data.apimodels.NewsArticleModel
import ir.hamidrezaamz.data.db.entity.NewsArticleEntity

class NewsTopHeadlineListAdapter(
    private val list: List<NewsArticleEntity>,
    private val recyclerViewListCallback: RecyclerViewListCallback? = null
) : RecyclerView.Adapter<NewsTopHeadlineViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsTopHeadlineViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return NewsTopHeadlineViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: NewsTopHeadlineViewHolder, position: Int) {
        holder.bind(list[position], recyclerViewListCallback)
    }

    override fun getItemCount(): Int = list.size

}