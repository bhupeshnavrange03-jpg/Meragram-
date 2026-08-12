package com.meragrams.data.repository

import com.meragrams.data.model.Notification
import com.meragrams.data.model.NotificationType

class NotificationRepository {
    private val notifications = mutableListOf<Notification>()

    init {
        notifications.addAll(
            listOf(
                Notification(
                    id = "n1",
                    type = NotificationType.LIKE,
                    fromUsername = "priyasingh",
                    fromProfileImage = "https://via.placeholder.com/150/00D9FF/ffffff?text=PS",
                    message = "liked your post",
                    timestamp = "1 hour ago",
                    postId = "1"
                ),
                Notification(
                    id = "n2",
                    type = NotificationType.COMMENT,
                    fromUsername = "rajkumar",
                    fromProfileImage = "https://via.placeholder.com/150/FF6B9D/ffffff?text=RK",
                    message = "commented on your post",
                    timestamp = "2 hours ago",
                    postId = "2"
                ),
                Notification(
                    id = "n3",
                    type = NotificationType.FOLLOW,
                    fromUsername = "priyasingh",
                    fromProfileImage = "https://via.placeholder.com/150/00D9FF/ffffff?text=PS",
                    message = "started following you",
                    timestamp = "3 hours ago"
                ),
                Notification(
                    id = "n4",
                    type = NotificationType.LIKE,
                    fromUsername = "rajkumar",
                    fromProfileImage = "https://via.placeholder.com/150/FF6B9D/ffffff?text=RK",
                    message = "liked your post",
                    timestamp = "5 hours ago",
                    postId = "3"
                )
            )
        )
    }

    fun getNotifications(): List<Notification> = notifications

    fun addNotification(notification: Notification) {
        notifications.add(0, notification)
    }
}
