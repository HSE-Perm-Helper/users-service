package ru.melowetty.usersservice.domain.entity

import jakarta.persistence.Column
import jakarta.persistence.Embeddable

@Embeddable
data class UserTelegramInfoEntity(
    @Column(name = "telegram_id", nullable = false)
    val telegramId: Long,

    @Column(name = "telegram_username")
    val username: String?,

    @Column(name = "telegram_first_name", nullable = false)
    val firstName: String,

    @Column(name = "telegram_last_name")
    val lastName: String?
)
