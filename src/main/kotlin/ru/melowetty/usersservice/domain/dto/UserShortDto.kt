package ru.melowetty.usersservice.domain.dto

import java.time.LocalDateTime
import java.util.UUID

data class UserShortDto(
    val id: UUID,
    val telegramInfo: UserTelegramInfoDto,
    val mainSettings: SettingsDto,
    val creationDate: LocalDateTime
)
