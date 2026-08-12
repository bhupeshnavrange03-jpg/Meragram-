package com.meragrams.data.repository

import com.meragrams.data.model.Post
import com.meragrams.data.model.Story

class FeedRepository {
    private val posts = mutableListOf<Post>()
    private val stories = mutableListOf<Story>()

    init {
        posts.addAll(
            listOf(
                Post(
                    id = "1",
                    userId = "1",
                    username = "rajkumar",
                    profileImage = "https://via.placeholder.com/150/FF6B9D/ffffff?text=RK",
                    imageUrl = "https://via.placeholder.com/400x300/FF6B9D/ffffff?text=Mountain+View",
                    caption = "Morning views from the mountains! 🏔️ Nothing beats nature at sunrise.",
                    timestamp = "2 hours ago",
                    likes = 342,
                    isLiked = false
                ),
                Post(
                    id = "2",
                    userId = "2",
                    username = "priyasingh",
                    profileImage = "https://via.placeholder.com/150/00D9FF/ffffff?text=PS",
                    imageUrl = "https://via.placeholder.com/400x300/00D9FF/ffffff?text=Art+Work",
                    caption = "Working on my latest design project 🎨 Creative energy is flowing!",
                    timestamp = "4 hours ago",
                    likes = 567,
                    isLiked = false
                ),
                Post(
                    id = "3",
                    userId = "1",
                    username = "rajkumar",
                    profileImage = "https://via.placeholder.com/150/FF6B9D/ffffff?text=RK",
                    imageUrl = "https://via.placeholder.com/400x300/FF6B9D/ffffff?text=Coffee+Time",
                    caption = "My happy place ☕ Coffee and good vibes!",
                    timestamp = "6 hours ago",
                    likes = 289,
                    isLiked = false
                ),
                Post(
                    id = "4",
                    userId = "2",
                    username = "priyasingh",
                    profileImage = "https://via.placeholder.com/150/00D9FF/ffffff?text=PS",
                    imageUrl = "https://via.placeholder.com/400x300/00D9FF/ffffff?text=Studio+Life",
                    caption = "Studio days are the best days! 🖌️ Creating magic here.",
                    timestamp = "8 hours ago",
                    likes = 423,
                    isLiked = false
                )
            )
        )

        stories.addAll(
            listOf(
                Story(
                    id = "s1",
                    userId = "1",
                    username = "rajkumar",
                    profileImage = "https://via.placeholder.com/150/FF6B9D/ffffff?text=RK",
                    content = "Story content 1"
                ),
                Story(
                    id = "s2",
                    userId = "2",
                    username = "priyasingh",
                    profileImage = "https://via.placeholder.com/150/00D9FF/ffffff?text=PS",
                    content = "Story content 2"
                )
            )
        )
    }

    fun getPosts(): List<Post> = posts

    fun addPost(post: Post) {
        posts.add(0, post)
    }

    fun likePost(postId: String) {
        val post = posts.find { it.id == postId }
        if (post != null) {
            if (post.isLiked) {
                post.likes--
                post.isLiked = false
            } else {
                post.likes++
                post.isLiked = true
            }
        }
    }

    fun getStories(): List<Story> = stories

    fun getUserPosts(userId: String): List<Post> = posts.filter { it.userId == userId }

    fun searchPosts(query: String): List<Post> {
        return posts.filter {
            it.caption.contains(query, ignoreCase = true) ||
                    it.username.contains(query, ignoreCase = true)
        }
    }
}
