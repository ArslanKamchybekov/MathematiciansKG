package kg.geektech.mathematicianskg.domain.models

data class MainNews(
    var status: String,
    var totalResults: String,
    var articles: ArrayList<MainModel>
)
