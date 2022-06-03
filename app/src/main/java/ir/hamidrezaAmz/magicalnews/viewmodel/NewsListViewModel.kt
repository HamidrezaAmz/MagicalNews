package ir.hamidrezaAmz.magicalnews.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.hamidrezaamz.data.apimodels.NewsResponseModel
import ir.hamidrezaamz.domain.repository.remote.base.ApiResult
import ir.hamidrezaamz.domain.usecases.NewsListUseCase
import javax.inject.Inject

@HiltViewModel
class NewsListViewModel @Inject constructor(
    private val newsListUseCase: NewsListUseCase
) : ViewModel() {

    private val _newsListMutableLiveData = MutableLiveData<ApiResult<NewsResponseModel>>()
    val newsListLiveData: LiveData<ApiResult<NewsResponseModel>>
        get() = _newsListMutableLiveData

    suspend fun getNewsList() {
        _newsListMutableLiveData.postValue(ApiResult.Loading())
        _newsListMutableLiveData.postValue(newsListUseCase.invoke())
    }

}