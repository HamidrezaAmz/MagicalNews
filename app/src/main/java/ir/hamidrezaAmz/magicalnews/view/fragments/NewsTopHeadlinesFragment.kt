package ir.hamidrezaAmz.magicalnews.view.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import ir.hamidrezaAmz.magicalnews.R
import ir.hamidrezaAmz.magicalnews.databinding.FragmentNewsTopHeadlinesBinding
import ir.hamidrezaAmz.magicalnews.view.adapter.NewsTopHeadlineListAdapter
import ir.hamidrezaAmz.magicalnews.view.fragments.base.BaseFragmentBinding
import ir.hamidrezaAmz.magicalnews.view.myInterfaces.RecyclerViewListCallback
import ir.hamidrezaAmz.magicalnews.viewmodel.NewsTopHeadlinesViewModel
import ir.hamidrezaamz.data.db.entity.NewsArticleEntity
import ir.hamidrezaamz.data.extras.PublicValue.Companion.KEY_DEFAULT_NEWS_SOURCE_ID
import ir.hamidrezaamz.data.extras.PublicValue.Companion.KEY_NEWS_SOURCE_ID

@AndroidEntryPoint
class NewsTopHeadlinesFragment : BaseFragmentBinding<FragmentNewsTopHeadlinesBinding>(), RecyclerViewListCallback {

    private lateinit var newsSourceID: String

    private val viewModel: NewsTopHeadlinesViewModel by viewModels()

    override fun getLayoutResourceId(): Int {
        return R.layout.fragment_news_top_headlines
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
    }

    override fun onItemClicked(item: Any?) {
        // we have a click here! so... :)
    }

    private fun initialize() {
        newsSourceID = arguments?.getString(KEY_NEWS_SOURCE_ID) ?: KEY_DEFAULT_NEWS_SOURCE_ID
        initializeToolbar()
        initializeViewModel()
    }

    private fun initializeToolbar() {
        val activityTitle = newsSourceID
            .replace("-", " ")
            .capitalize()
        activity?.title = activityTitle
    }

    private fun initializeViewModel() {

        viewModel.newsTopHeadlinesListLiveData.observe(viewLifecycleOwner) {
            parseData(it)
        }

        fetchData()
    }

    private fun fetchData() {
        viewModel.getNewsTopHeadlines(newsSourceID)
    }

    private fun parseData(newsArticleEntity: List<NewsArticleEntity>?) {
        newsArticleEntity?.let { _newsArticleList ->
            getBinding().recyclerView.apply {
                layoutManager = LinearLayoutManager(activity)
                adapter = NewsTopHeadlineListAdapter(_newsArticleList, this@NewsTopHeadlinesFragment)
            }
        }
    }

}