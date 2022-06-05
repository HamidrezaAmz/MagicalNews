package ir.hamidrezaAmz.magicalnews.view.fragments

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import ir.hamidrezaAmz.magicalnews.R
import ir.hamidrezaAmz.magicalnews.databinding.FragmentNewsAgencyListBinding
import ir.hamidrezaAmz.magicalnews.view.adapter.NewsSourceListAdapter
import ir.hamidrezaAmz.magicalnews.view.fragments.base.BaseFragmentBinding
import ir.hamidrezaAmz.magicalnews.view.myInterfaces.RecyclerViewListCallback
import ir.hamidrezaAmz.magicalnews.viewmodel.NewsSourceListViewModel
import ir.hamidrezaamz.data.db.entity.NewsSourceEntity
import ir.hamidrezaamz.data.extras.PublicValue

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
        if (item is NewsSourceEntity) {
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
        viewModel.newsSourceListLiveData.observe(viewLifecycleOwner) {
            parseData(it)
        }

        fetchData()
    }

    private fun fetchData() {
        viewModel.getNewsSourceList()
    }

    private fun parseData(newsSourceList: List<NewsSourceEntity>?) {
        newsSourceList?.let { _newsSourceList ->
            getBinding().recyclerView.apply {
                layoutManager = LinearLayoutManager(activity)
                addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
                adapter = NewsSourceListAdapter(_newsSourceList, this@NewsSourceListFragment)
            }
        }
    }

}