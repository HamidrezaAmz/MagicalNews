package ir.hamidrezaAmz.magicalnews.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ir.hamidrezaAmz.magicalnews.view.adapter.viewholder.NewsSourceViewHolder
import ir.hamidrezaAmz.magicalnews.view.myInterfaces.RecyclerViewListCallback
import ir.hamidrezaamz.data.db.entity.NewsSourceEntity

class NewsSourceListAdapter(
    private val list: List<NewsSourceEntity>,
    private val recyclerViewListCallback: RecyclerViewListCallback? = null
) : RecyclerView.Adapter<NewsSourceViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsSourceViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return NewsSourceViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: NewsSourceViewHolder, position: Int) {
        holder.bind(list[position], recyclerViewListCallback)
    }

    override fun getItemCount(): Int = list.size

}