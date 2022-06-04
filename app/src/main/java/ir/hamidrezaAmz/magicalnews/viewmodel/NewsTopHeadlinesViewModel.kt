package ir.hamidrezaAmz.magicalnews.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.hamidrezaamz.data.apimodels.NewsTopHeadlinesResponseModel
import ir.hamidrezaamz.domain.repository.remote.base.ApiResult
import ir.hamidrezaamz.domain.usecases.NewsTopHeadlineListUseCase
import javax.inject.Inject

@HiltViewModel
class NewsTopHeadlinesViewModel @Inject constructor(
    private val newsTopHeadlineListUseCase: NewsTopHeadlineListUseCase
) : ViewModel() {

    private val _newsTopHeadlinesListMutableLiveData = MutableLiveData<ApiResult<NewsTopHeadlinesResponseModel>>()
    val newsTopHeadlinesListLiveData: LiveData<ApiResult<NewsTopHeadlinesResponseModel>>
        get() = _newsTopHeadlinesListMutableLiveData

    suspend fun getNewsTopHeadlines(sourceId: String) {
        _newsTopHeadlinesListMutableLiveData.postValue(ApiResult.Loading())
        _newsTopHeadlinesListMutableLiveData.postValue(newsTopHeadlineListUseCase.invoke(sourceId = sourceId))
    }

}