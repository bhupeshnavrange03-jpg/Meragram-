package com.meragrams.viewmodel

import androidx.lifecycle.ViewModel
import com.meragrams.data.model.Post
import com.meragrams.data.model.User
import com.meragrams.data.repository.AuthRepository
import com.meragrams.data.repository.FeedRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class ProfileViewModel : ViewModel() {
    private val authRepository = AuthRepository()
    private val feedRepository = FeedRepository()

    private val _currentUser = MutableStateFlow<User?>(null)
    val currentUser: StateFlow<User?> = _currentUser.asStateFlow()

    private val _userPosts = MutableStateFlow<List<Post>>(emptyList())
    val userPosts: StateFlow<List<Post>> = _userPosts.asStateFlow()

    fun loadUserProfile(user: User?) {
        _currentUser.value = user
        if (user != null) {
            _userPosts.value = feedRepository.getUserPosts(user.id)
        }
    }

    fun updateProfile(user: User) {
        authRepository.updateUserProfile(user)
        _currentUser.value = user
    }
}
