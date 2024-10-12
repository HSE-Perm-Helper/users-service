package ru.melowetty.usersservice.domain.entity

import jakarta.persistence.Column

data class UserTelegramInfoEntity(
    @Column(name = "telegram_username")
    val username: String?,

    @Column(name = "telegram_first_name", nullable = false)
    val firstName: String,

    @Column(name = "telegram_last_name")
    val lastName: String?
)
