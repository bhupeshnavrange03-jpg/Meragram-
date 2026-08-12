package com.meragrams.viewmodel

import androidx.lifecycle.ViewModel
import com.meragrams.data.model.Post
import com.meragrams.data.model.Story
import com.meragrams.data.repository.FeedRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class FeedViewModel : ViewModel() {
    private val feedRepository = FeedRepository()

    private val _posts = MutableStateFlow<List<Post>>(emptyList())
    val posts: StateFlow<List<Post>> = _posts.asStateFlow()

    private val _stories = MutableStateFlow<List<Story>>(emptyList())
    val stories: StateFlow<List<Story>> = _stories.asStateFlow()

    init {
        loadFeed()
    }

    fun loadFeed() {
        _posts.value = feedRepository.getPosts()
        _stories.value = feedRepository.getStories()
    }

    fun addPost(post: Post) {
        feedRepository.addPost(post)
        _posts.value = feedRepository.getPosts()
    }

    fun likePost(postId: String) {
        feedRepository.likePost(postId)
        _posts.value = feedRepository.getPosts()
    }

    fun getUserPosts(userId: String): List<Post> {
        return feedRepository.getUserPosts(userId)
    }
}
