package ir.hamidrezaAmz.magicalnews.view.adapter.viewholder

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import ir.hamidrezaAmz.magicalnews.R
import ir.hamidrezaamz.data.apimodels.SourceModel

class NewsSourceViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.recyclerview_news_source_list_item, parent, false)),
    View.OnClickListener {

    private var mTitleView: AppCompatTextView? = null

    init {
        mTitleView = itemView.findViewById(R.id.appCompatTextView_title)
    }

    fun bind(sourceModel: SourceModel) {
        mTitleView?.text = sourceModel.name
    }

    override fun onClick(view: View?) {
        TODO("Not yet implemented")
    }
}