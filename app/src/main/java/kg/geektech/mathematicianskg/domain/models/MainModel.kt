package kg.geektech.mathematicianskg.domain.models

import kg.geektech.mathematicianskg.presentation.callbacks.Models

data class MainModel(
    var id: Int,
    var author: String,
    var title: String,
    var description: String,
    var url: String,
    var urlToImage: String
) : Models