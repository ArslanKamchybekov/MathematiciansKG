package kg.geektech.mathematicianskg.data.remote

import kg.geektech.mathematicianskg.domain.models.MainNews
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {

    @GET("top-headlines")
    fun getNews(
        @Query("country") country: String?,
        @Query("pageSize") pagesize: Int,
        @Query("apiKey") apikey: String?
    ): Response<MainNews>

    @GET("top-headlines")
    fun getCategoryNews(
        @Query("country") country: String?,
        @Query("category") category: String?,
        @Query("pageSize") pagesize: Int,
        @Query("apiKey") apikey: String?
    ): Response<MainNews>
}