package ir.hamidrezaAmz.magicalnews.view.fragments

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import dagger.hilt.android.AndroidEntryPoint
import ir.hamidrezaAmz.magicalnews.R
import ir.hamidrezaAmz.magicalnews.databinding.FragmentNewsAgencyListBinding
import ir.hamidrezaAmz.magicalnews.view.base.BaseFragmentBinding
import ir.hamidrezaAmz.magicalnews.viewmodel.NewsAgencyListViewModel
import kotlinx.coroutines.launch

@AndroidEntryPoint
class NewsAgencyListFragment : BaseFragmentBinding<FragmentNewsAgencyListBinding>() {

    private val viewModel: NewsAgencyListViewModel by viewModels()

    override fun getLayoutResourceId(): Int {
        return R.layout.fragment_news_agency_list
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
    }

    private fun initialize() {

        viewModel.newsListLiveData.observe(viewLifecycleOwner) {
            Log.i(TAG, "initialize: newsAgencyListLiveData -> ${it.size}")
        }

        fetchData()
    }

    private fun fetchData() {
        lifecycleScope.launch {
            viewModel.getNewsList()
        }
    }

}