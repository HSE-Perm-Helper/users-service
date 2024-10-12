package ru.melowetty.usersservice.domain.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.JoinTable
import jakarta.persistence.ManyToMany
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import java.time.LocalDate
import java.time.LocalDateTime
import java.util.*
import org.hibernate.annotations.CreationTimestamp

@Entity
@Table(name = "users")
open class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    open var id: UUID? = null

    @Column(name = "telegram_id", nullable = false)
    open var telegramId: Long = 0L

    @ManyToOne
    @JoinColumn(name = "current_settings_id", nullable = false)
    open lateinit var currentSettings: SettingsEntity

    @ManyToOne
    @JoinColumn(name = "main_settings_id", nullable = false)
    open lateinit var mainSettings: SettingsEntity

    @ManyToMany(fetch = FetchType.LAZY)
    open lateinit var availableSettings: HashSet<SettingsEntity>

    @Column(name = "creation_date")
    @CreationTimestamp
    open lateinit var creationDate: LocalDateTime
}