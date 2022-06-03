package ir.hamidrezaAmz.magicalnews.view.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import dagger.hilt.android.AndroidEntryPoint
import ir.hamidrezaAmz.magicalnews.R
import ir.hamidrezaAmz.magicalnews.databinding.FragmentNewsAgencyListBinding
import ir.hamidrezaAmz.magicalnews.view.base.BaseFragmentBinding
import ir.hamidrezaAmz.magicalnews.viewmodel.NewsListViewModel
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

        viewModel.newsListLiveData.observe(viewLifecycleOwner) { _apiResult ->
            when (_apiResult.apiStatus) {
                ApiResult.ApiStatus.LOADING -> {
                    getBinding().progressBar.visibility = View.VISIBLE
                }
                ApiResult.ApiStatus.SUCCESS -> {
                    getBinding().progressBar.visibility = View.GONE
                }
                ApiResult.ApiStatus.ERROR -> {
                    getBinding().progressBar.visibility = View.GONE
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
            viewModel.getNewsList()
        }
    }

}