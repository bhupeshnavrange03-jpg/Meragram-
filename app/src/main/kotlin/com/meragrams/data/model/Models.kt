package com.meragrams.data.model

data class User(
    val id: String,
    val fullName: String,
    val username: String,
    val email: String,
    val password: String,
    val bio: String = "",
    val profileImage: String = "https://via.placeholder.com/150",
    val followers: Int = 0,
    val following: Int = 0,
    val postsCount: Int = 0
)

data class Post(
    val id: String,
    val userId: String,
    val username: String,
    val profileImage: String,
    val imageUrl: String,
    val caption: String,
    val timestamp: String,
    var likes: Int = 0,
    var isLiked: Boolean = false,
    val comments: List<Comment> = emptyList()
)

data class Comment(
    val id: String,
    val userId: String,
    val username: String,
    val text: String,
    val timestamp: String
)

data class Story(
    val id: String,
    val userId: String,
    val username: String,
    val profileImage: String,
    val content: String
)

data class Notification(
    val id: String,
    val type: NotificationType,
    val fromUsername: String,
    val fromProfileImage: String,
    val message: String,
    val timestamp: String,
    val postId: String? = null
)

enum class NotificationType {
    LIKE, COMMENT, FOLLOW
}
