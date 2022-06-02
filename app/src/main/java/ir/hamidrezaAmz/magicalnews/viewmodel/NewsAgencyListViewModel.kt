package ir.hamidrezaAmz.magicalnews.viewmodel

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel

@HiltViewModel
class NewsAgencyListViewModel<T> : ViewModel() {

    fun getNewsAgencyList(): List<T> {
        return listOf()
    }

}