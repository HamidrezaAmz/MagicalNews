package ir.hamidrezaAmz.magicalnews.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.hamidrezaamz.data.db.entity.NewsSourceEntity
import ir.hamidrezaamz.domain.usecases.NewsSourceListUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsSourceListViewModel @Inject constructor(
    private val newsSourceListUseCase: NewsSourceListUseCase
) : ViewModel() {

    private val _newsSourceListMutableLiveData = MutableLiveData<List<NewsSourceEntity>>()
    val newsSourceListLiveData: LiveData<List<NewsSourceEntity>>
        get() = _newsSourceListMutableLiveData

    fun getNewsSourceList() {
        viewModelScope.launch(Dispatchers.IO) {
            newsSourceListUseCase.invoke()
                .onEach { _newsSourceEntityList ->
                    _newsSourceEntityList.data.let { _newsSourceListMutableLiveData.postValue(it) }
                }
                .launchIn(this)
        }
    }

}