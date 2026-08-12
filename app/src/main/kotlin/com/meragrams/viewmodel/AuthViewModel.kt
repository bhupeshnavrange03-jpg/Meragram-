package com.meragrams.viewmodel

import androidx.lifecycle.ViewModel
import com.meragrams.data.model.User
import com.meragrams.data.repository.AuthRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class AuthViewModel : ViewModel() {
    private val authRepository = AuthRepository()

    private val _isLoggedIn = MutableStateFlow(false)
    val isLoggedIn: StateFlow<Boolean> = _isLoggedIn.asStateFlow()

    private val _currentUser = MutableStateFlow<User?>(null)
    val currentUser: StateFlow<User?> = _currentUser.asStateFlow()

    fun login(emailOrUsername: String, password: String): Boolean {
        return if (authRepository.login(emailOrUsername, password)) {
            _currentUser.value = authRepository.getCurrentUser()
            _isLoggedIn.value = true
            true
        } else {
            false
        }
    }

    fun signup(fullName: String, username: String, email: String, password: String): Boolean {
        return if (authRepository.signup(fullName, username, email, password)) {
            _currentUser.value = authRepository.getCurrentUser()
            _isLoggedIn.value = true
            true
        } else {
            false
        }
    }

    fun logout() {
        authRepository.logout()
        _currentUser.value = null
        _isLoggedIn.value = false
    }

    fun getAuthRepository() = authRepository
}
