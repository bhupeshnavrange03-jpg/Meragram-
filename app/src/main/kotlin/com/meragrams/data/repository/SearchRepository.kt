package com.meragrams.data.repository

import com.meragrams.data.model.Post
import com.meragrams.data.model.User

class SearchRepository(
    private val authRepository: AuthRepository,
    private val feedRepository: FeedRepository
) {
    fun searchUsers(query: String): List<User> {
        val allUsers = listOf(
            User("1", "Raj Kumar", "rajkumar", "raj@example.com", "pass", "Photography & Travel", followers = 245),
            User("2", "Priya Singh", "priyasingh", "priya@example.com", "pass", "Artist | Designer", followers = 512),
            User("3", "Amit Patel", "amitpatel", "amit@example.com", "pass", "Tech Enthusiast", followers = 178),
            User("4", "Neha Sharma", "nehasharma", "neha@example.com", "pass", "Fitness Coach", followers = 892),
        )
        return if (query.isEmpty()) emptyList()
        else allUsers.filter {
            it.username.contains(query, ignoreCase = true) ||
                    it.fullName.contains(query, ignoreCase = true)
        }
    }

    fun searchPosts(query: String): List<Post> {
        return feedRepository.searchPosts(query)
    }
}
