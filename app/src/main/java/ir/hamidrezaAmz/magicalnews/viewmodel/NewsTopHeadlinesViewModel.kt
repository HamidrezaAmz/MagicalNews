package ir.hamidrezaAmz.magicalnews.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.hamidrezaamz.data.db.entity.NewsArticleEntity
import ir.hamidrezaamz.domain.usecases.NewsTopHeadlineListUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsTopHeadlinesViewModel @Inject constructor(
    private val newsTopHeadlineListUseCase: NewsTopHeadlineListUseCase
) : ViewModel() {

    private val _newsTopHeadlinesListMutableLiveData = MutableLiveData<List<NewsArticleEntity>>()
    val newsTopHeadlinesListLiveData: LiveData<List<NewsArticleEntity>>
        get() = _newsTopHeadlinesListMutableLiveData

    fun getNewsTopHeadlines(sourceId: String) {
        viewModelScope.launch(Dispatchers.IO) {
            newsTopHeadlineListUseCase.invoke(sourceId)
                .onEach { _newsArticleEntityList ->
                    _newsArticleEntityList.data.let { _newsTopHeadlinesListMutableLiveData.postValue(it) }
                }
                .launchIn(this)
        }
    }

}