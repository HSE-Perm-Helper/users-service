package ru.melowetty.usersservice.domain.dto

import java.time.LocalDateTime
import java.util.UUID

data class UserDto(
    val id: UUID,
    val telegramInfoDto: UserTelegramInfoDto,
    val currentSettings: SettingsDto,
    val mainSettings: SettingsDto,
    val availableSettings: Set<SettingsDto>,
    val createdDate: LocalDateTime
)
