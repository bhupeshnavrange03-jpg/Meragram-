package com.meragrams.data.repository

import com.meragrams.data.model.User

class AuthRepository {
    private val users = mutableListOf<User>()
    private var currentUser: User? = null

    init {
        users.add(
            User(
                id = "1",
                fullName = "Raj Kumar",
                username = "rajkumar",
                email = "raj@example.com",
                password = "password123",
                bio = "Photography & Travel Enthusiast 📸",
                profileImage = "https://via.placeholder.com/150/FF6B9D/ffffff?text=RK",
                followers = 245,
                following = 189,
                postsCount = 42
            )
        )
        users.add(
            User(
                id = "2",
                fullName = "Priya Singh",
                username = "priyasingh",
                email = "priya@example.com",
                password = "password123",
                bio = "Artist | Designer | Coffee lover ☕",
                profileImage = "https://via.placeholder.com/150/00D9FF/ffffff?text=PS",
                followers = 512,
                following = 234,
                postsCount = 87
            )
        )
    }

    fun signup(fullName: String, username: String, email: String, password: String): Boolean {
        if (users.any { it.email == email || it.username == username }) {
            return false
        }
        val newUser = User(
            id = (users.size + 1).toString(),
            fullName = fullName,
            username = username,
            email = email,
            password = password
        )
        users.add(newUser)
        currentUser = newUser
        return true
    }

    fun login(emailOrUsername: String, password: String): Boolean {
        val user = users.find {
            (it.email == emailOrUsername || it.username == emailOrUsername) && it.password == password
        }
        if (user != null) {
            currentUser = user
            return true
        }
        return false
    }

    fun logout() {
        currentUser = null
    }

    fun getCurrentUser(): User? = currentUser

    fun getUserByUsername(username: String): User? = users.find { it.username == username }

    fun updateUserProfile(user: User) {
        val index = users.indexOfFirst { it.id == user.id }
        if (index != -1) {
            users[index] = user
            currentUser = user
        }
    }
}
