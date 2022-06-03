package ir.hamidrezaAmz.magicalnews.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.hamidrezaamz.domain.models.NewsAgencyModel
import ir.hamidrezaamz.domain.usecases.NewsAgencyListUseCase
import javax.inject.Inject

@HiltViewModel
class NewsAgencyListViewModel @Inject constructor(
    private val newsAgencyListUseCase: NewsAgencyListUseCase
) : ViewModel() {

    private val _newsAgencyListMutableLiveData = MutableLiveData<List<NewsAgencyModel>>()
    val newsAgencyListLiveData: LiveData<List<NewsAgencyModel>>
        get() = _newsAgencyListMutableLiveData

    suspend fun getNewsAgencyList() {
        _newsAgencyListMutableLiveData.postValue(newsAgencyListUseCase.invoke())
    }

}