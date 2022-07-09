package kg.geektech.mathematicianskg.presentation.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kg.geektech.mathematicianskg.domain.models.MainNews
import kg.geektech.mathematicianskg.domain.repository.NewsRepository
import kg.geektech.mathematicianskg.domain.use_cases.GetNewsListUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(repository: NewsRepository) : ViewModel() {

    private val getNewsListUseCase = GetNewsListUseCase(repository)
    val news = MutableLiveData<MainNews>()

    init {
        getNewsList("science", 100)
    }

    private fun getNewsList(category: String, page: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            kotlin.runCatching {
                val call = getNewsListUseCase.getNewsList(category, page)
                if (call.isSuccessful) news.postValue(call.body())
            }
        }
    }

}