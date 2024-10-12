package ru.melowetty.usersservice.domain.dto

data class SettingsDto(
    val id: Long,
    val ownerTelegramInfo: UserTelegramInfoDto,
    val isCurrentSettings: Boolean,
    val canEditSettings: Boolean,
    val group: String,
    val subGroup: Int = 0,
    val isEnabledNewScheduleNotifications: Boolean = true,
    val isEnabledChangedScheduleNotifications: Boolean = true,
    val isEnabledComingLessonsNotifications: Boolean = false
)