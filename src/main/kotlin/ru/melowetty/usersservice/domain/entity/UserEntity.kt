package ru.melowetty.usersservice.domain.entity

import jakarta.persistence.Column
import jakarta.persistence.Embedded
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToMany
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import java.time.LocalDateTime
import java.util.*
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.proxy.HibernateProxy

@Entity
@Table(name = "users")
open class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    open var id: UUID? = null

    @Column(name = "telegram_id", nullable = false)
    open var telegramId: Long = 0L

    @Embedded
    open lateinit var telegramInfo: UserTelegramInfoEntity

    @ManyToOne
    @JoinColumn(name = "current_settings_id", nullable = false)
    open lateinit var currentSettings: SettingsEntity

    @ManyToOne
    @JoinColumn(name = "main_settings_id", nullable = false)
    open lateinit var mainSettings: SettingsEntity

    @ManyToMany(fetch = FetchType.LAZY)
    open lateinit var availableSettings: HashSet<SettingsEntity>

    @Column(name = "creation_date", nullable = false)
    @CreationTimestamp
    open lateinit var creationDate: LocalDateTime

    final override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null) return false
        val oEffectiveClass =
            if (other is HibernateProxy) other.hibernateLazyInitializer.persistentClass else other.javaClass
        val thisEffectiveClass =
            if (this is HibernateProxy) this.hibernateLazyInitializer.persistentClass else this.javaClass
        if (thisEffectiveClass != oEffectiveClass) return false
        other as UserEntity

        return id != null && id == other.id
    }

    final override fun hashCode(): Int =
        if (this is HibernateProxy) this.hibernateLazyInitializer.persistentClass.hashCode() else javaClass.hashCode()

}