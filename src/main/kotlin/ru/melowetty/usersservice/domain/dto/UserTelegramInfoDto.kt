package ru.melowetty.usersservice.domain.dto

data class UserTelegramInfoDto(
    val telegramId: Long,
    val username: String?,
    val firstName: String,
    val lastName: String?
)