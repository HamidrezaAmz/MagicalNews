package ir.hamidrezaAmz.magicalnews.view.fragments

import android.app.AlertDialog
import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import ir.hamidrezaAmz.magicalnews.R
import ir.hamidrezaAmz.magicalnews.databinding.FragmentNewsTopHeadlinesBinding
import ir.hamidrezaAmz.magicalnews.view.adapter.NewsTopHeadlineListAdapter
import ir.hamidrezaAmz.magicalnews.view.fragments.base.BaseFragmentBinding
import ir.hamidrezaAmz.magicalnews.view.myInterfaces.RecyclerViewListCallback
import ir.hamidrezaAmz.magicalnews.viewmodel.NewsTopHeadlinesViewModel
import ir.hamidrezaamz.data.apimodels.NewsTopHeadlinesResponseModel
import ir.hamidrezaamz.data.extras.PublicValue.Companion.KEY_DEFAULT_NEWS_SOURCE_ID
import ir.hamidrezaamz.data.extras.PublicValue.Companion.KEY_NEWS_SOURCE_ID
import ir.hamidrezaamz.domain.repository.remote.base.ApiResult
import kotlinx.coroutines.launch

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

        viewModel.newsTopHeadlinesListLiveData.observe(viewLifecycleOwner) { _apiResult ->
            when (_apiResult.apiStatus) {
                ApiResult.ApiStatus.LOADING -> {
                    getBinding().progressBar.visibility = View.VISIBLE
                }
                ApiResult.ApiStatus.SUCCESS -> {
                    getBinding().progressBar.visibility = View.GONE
                    parseData(_apiResult.data)
                }
                ApiResult.ApiStatus.ERROR -> {
                    getBinding().progressBar.visibility = View.GONE
                    showError(_apiResult.message)
                }
                ApiResult.ApiStatus.IDLE -> {
                    getBinding().progressBar.visibility = View.GONE
                }
            }
        }

        fetchData()
    }

    private fun fetchData() {
        lifecycleScope.launch {
            viewModel.getNewsTopHeadlines(newsSourceID)
        }
    }

    private fun parseData(newsTopHeadlines: NewsTopHeadlinesResponseModel?) {
        val newsArticleList = newsTopHeadlines?.articles
        newsArticleList?.let { _newsArticleList ->
            getBinding().recyclerView.apply {
                layoutManager = LinearLayoutManager(activity)
                adapter = NewsTopHeadlineListAdapter(_newsArticleList, this@NewsTopHeadlinesFragment)
            }
        }
    }

    private fun showError(message: String?) {
        val errorMessage = if (message.isNullOrEmpty()) "No error message found." else message
        AlertDialog.Builder(context)
            .setTitle("Error!")
            .setMessage(errorMessage)
            .setPositiveButton(android.R.string.ok, null)
            .show()
    }

}