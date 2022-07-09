package kg.geektech.mathematicianskg.domain.use_cases

import kg.geektech.mathematicianskg.domain.models.MainNews
import kg.geektech.mathematicianskg.domain.repository.NewsRepository
import retrofit2.Response

class GetNewsListUseCase(private val repository: NewsRepository) {

    suspend fun getNewsList(category: String, page: Int): Response<MainNews> {
        return repository.getNewsList(category, page)
    }
}