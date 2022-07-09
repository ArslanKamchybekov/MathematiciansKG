package kg.geektech.mathematicianskg.domain.repository

import kg.geektech.mathematicianskg.domain.models.MainNews
import retrofit2.Response

interface NewsRepository {

    suspend fun getNewsList(category: String, page: Int): Response<MainNews>

}
