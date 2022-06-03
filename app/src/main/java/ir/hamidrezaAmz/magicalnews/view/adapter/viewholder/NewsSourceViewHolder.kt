package ir.hamidrezaAmz.magicalnews.view.adapter.viewholder

import android.util.Log
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

    private var textViewTitle: AppCompatTextView? = null
    private var textViewDescription: AppCompatTextView? = null

    init {
        textViewTitle = itemView.findViewById(R.id.appCompatTextView_title)
        textViewDescription = itemView.findViewById(R.id.appCompatTextView_description)

        itemView.setOnClickListener(this)
    }

    fun bind(sourceModel: SourceModel) {
        textViewTitle?.text = sourceModel.name
        textViewDescription?.text = sourceModel.description
    }

    override fun onClick(view: View?) {
        Log.i("TAG", "onClick: ")
    }
}