package com.example.itqan2.models

data class Post(
    val id: Int,
    val title: String,
    val description: String,
    val mediaUrl: String,
    val mediaType: MediaType
)

enum class MediaType {
    IMAGE, VIDEO, AUDIO
}