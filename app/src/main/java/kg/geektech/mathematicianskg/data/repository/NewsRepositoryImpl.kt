package kg.geektech.mathematicianskg.data.repository

import kg.geektech.mathematicianskg.data.remote.NewsApi
import kg.geektech.mathematicianskg.domain.models.MainNews
import kg.geektech.mathematicianskg.domain.repository.NewsRepository
import retrofit2.Call
import retrofit2.Response
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(private val api: NewsApi) : NewsRepository {
    override suspend fun getNewsList(category: String, page: Int): Response<MainNews> {
        return api.getCategoryNews("us", category, page, "aac337da07724e8e875dfe50e999444d")
    }
}