package com.meragrams.viewmodel

import androidx.lifecycle.ViewModel
import com.meragrams.data.model.Post
import com.meragrams.data.model.User
import com.meragrams.data.repository.FeedRepository
import com.meragrams.data.repository.AuthRepository
import com.meragrams.data.repository.SearchRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class SearchViewModel : ViewModel() {
    private val searchRepository = SearchRepository(AuthRepository(), FeedRepository())

    private val _searchUsers = MutableStateFlow<List<User>>(emptyList())
    val searchUsers: StateFlow<List<User>> = _searchUsers.asStateFlow()

    private val _searchPosts = MutableStateFlow<List<Post>>(emptyList())
    val searchPosts: StateFlow<List<Post>> = _searchPosts.asStateFlow()

    fun searchUsers(query: String) {
        _searchUsers.value = searchRepository.searchUsers(query)
        _searchPosts.value = searchRepository.searchPosts(query)
    }

    fun clearSearch() {
        _searchUsers.value = emptyList()
        _searchPosts.value = emptyList()
    }
}
