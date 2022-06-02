package ir.hamidrezaAmz.magicalnews.view.fragments

import android.os.Bundle
import android.view.View
import ir.hamidrezaAmz.magicalnews.R
import ir.hamidrezaAmz.magicalnews.databinding.FragmentNewsAgencyDetailsBinding
import ir.hamidrezaAmz.magicalnews.view.base.BaseFragmentBinding

class NewsAgencyDetailsFragment : BaseFragmentBinding<FragmentNewsAgencyDetailsBinding>() {

    override fun getLayoutResourceId(): Int {
        return R.layout.fragment_news_agency_details
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}