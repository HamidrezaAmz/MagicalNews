package ir.hamidrezaAmz.magicalnews.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.hamidrezaamz.domain.models.NewsModel
import ir.hamidrezaamz.domain.usecases.NewsListUseCase
import javax.inject.Inject

@HiltViewModel
class NewsAgencyListViewModel @Inject constructor(
    private val newsListUseCase: NewsListUseCase
) : ViewModel() {

    private val _newsListMutableLiveData = MutableLiveData<List<NewsModel>>()
    val newsListLiveData: LiveData<List<NewsModel>>
        get() = _newsListMutableLiveData

    suspend fun getNewsList() {
        _newsListMutableLiveData.postValue(newsListUseCase.invoke())
    }

}