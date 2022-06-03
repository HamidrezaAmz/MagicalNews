package ir.hamidrezaAmz.magicalnews.view.fragments

import android.app.AlertDialog
import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import ir.hamidrezaAmz.magicalnews.R
import ir.hamidrezaAmz.magicalnews.databinding.FragmentNewsAgencyListBinding
import ir.hamidrezaAmz.magicalnews.view.adapter.NewsSourceListAdapter
import ir.hamidrezaAmz.magicalnews.view.fragments.base.BaseFragmentBinding
import ir.hamidrezaAmz.magicalnews.viewmodel.NewsListViewModel
import ir.hamidrezaamz.data.apimodels.NewsSourceResponseModel
import ir.hamidrezaamz.domain.repository.remote.base.ApiResult
import kotlinx.coroutines.launch

@AndroidEntryPoint
class NewsAgencyListFragment : BaseFragmentBinding<FragmentNewsAgencyListBinding>() {

    private val viewModel: NewsListViewModel by viewModels()

    override fun getLayoutResourceId(): Int {
        return R.layout.fragment_news_agency_list
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
    }

    private fun initialize() {

        viewModel.newsSourceListLiveData.observe(viewLifecycleOwner) { _apiResult ->
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
            viewModel.getNewsSourceList()
        }
    }

    private fun parseData(newsSource: NewsSourceResponseModel?) {
        val newsSourceList = newsSource?.sources
        newsSourceList?.let { _newsSourceList ->
            getBinding().recyclerView.apply {
                layoutManager = LinearLayoutManager(activity)
                adapter = NewsSourceListAdapter(_newsSourceList)
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