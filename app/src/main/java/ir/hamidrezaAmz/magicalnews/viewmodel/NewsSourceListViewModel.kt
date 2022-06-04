package ir.hamidrezaAmz.magicalnews.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.hamidrezaamz.data.apimodels.NewsSourceResponseModel
import ir.hamidrezaamz.domain.repository.remote.base.ApiResult
import ir.hamidrezaamz.domain.usecases.NewsSourceListUseCase
import javax.inject.Inject

@HiltViewModel
class NewsSourceListViewModel @Inject constructor(
    private val newsSourceListUseCase: NewsSourceListUseCase
) : ViewModel() {

    private val _newsSourceListMutableLiveData = MutableLiveData<ApiResult<NewsSourceResponseModel>>()
    val newsSourceListLiveData: LiveData<ApiResult<NewsSourceResponseModel>>
        get() = _newsSourceListMutableLiveData

    suspend fun getNewsSourceList() {
        _newsSourceListMutableLiveData.postValue(ApiResult.Loading())
        _newsSourceListMutableLiveData.postValue(newsSourceListUseCase.invoke())
    }

}