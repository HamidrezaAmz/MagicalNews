package ir.hamidrezaAmz.magicalnews.view.fragments

import android.app.AlertDialog
import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import ir.hamidrezaAmz.magicalnews.R
import ir.hamidrezaAmz.magicalnews.databinding.FragmentNewsAgencyListBinding
import ir.hamidrezaAmz.magicalnews.view.adapter.NewsSourceListAdapter
import ir.hamidrezaAmz.magicalnews.view.fragments.base.BaseFragmentBinding
import ir.hamidrezaAmz.magicalnews.view.myInterfaces.RecyclerViewListCallback
import ir.hamidrezaAmz.magicalnews.viewmodel.NewsSourceListViewModel
import ir.hamidrezaamz.data.apimodels.NewsSourceModel
import ir.hamidrezaamz.data.apimodels.NewsSourceResponseModel
import ir.hamidrezaamz.data.extras.PublicValue
import ir.hamidrezaamz.domain.repository.remote.base.ApiResult
import kotlinx.coroutines.launch

@AndroidEntryPoint
class NewsSourceListFragment : BaseFragmentBinding<FragmentNewsAgencyListBinding>(), RecyclerViewListCallback {

    private val viewModel: NewsSourceListViewModel by viewModels()

    override fun getLayoutResourceId(): Int {
        return R.layout.fragment_news_agency_list
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
    }

    override fun onResume() {
        super.onResume()
        initializeToolbar()
    }

    override fun onItemClicked(item: Any?) {
        if (item is NewsSourceModel) {
            view?.let {
                val bundle = bundleOf(PublicValue.KEY_NEWS_SOURCE_ID to item.id)
                Navigation.findNavController(it).navigate(R.id.action_newsAgencyListFragment_to_newsAgencyDetailsFragment, bundle)
            }
        }
    }

    private fun initialize() {
        initializeToolbar()
        initializeViewModel()
    }

    private fun initializeToolbar() {
        activity?.title = getString(R.string.app_name)
    }

    private fun initializeViewModel() {
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
                adapter = NewsSourceListAdapter(_newsSourceList, this@NewsSourceListFragment)
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