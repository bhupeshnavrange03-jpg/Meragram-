package com.meragrams.viewmodel

import androidx.lifecycle.ViewModel
import com.meragrams.data.model.Notification
import com.meragrams.data.repository.NotificationRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class NotificationViewModel : ViewModel() {
    private val notificationRepository = NotificationRepository()

    private val _notifications = MutableStateFlow<List<Notification>>(emptyList())
    val notifications: StateFlow<List<Notification>> = _notifications.asStateFlow()

    init {
        loadNotifications()
    }

    fun loadNotifications() {
        _notifications.value = notificationRepository.getNotifications()
    }

    fun addNotification(notification: Notification) {
        notificationRepository.addNotification(notification)
        _notifications.value = notificationRepository.getNotifications()
    }
}
