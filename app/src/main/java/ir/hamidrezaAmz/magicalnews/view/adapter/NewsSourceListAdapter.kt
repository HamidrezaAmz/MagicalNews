package ir.hamidrezaAmz.magicalnews.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ir.hamidrezaAmz.magicalnews.view.adapter.viewholder.NewsSourceViewHolder
import ir.hamidrezaamz.data.apimodels.SourceModel

class NewsSourceListAdapter(private val list: List<SourceModel>) : RecyclerView.Adapter<NewsSourceViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsSourceViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return NewsSourceViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: NewsSourceViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size

}