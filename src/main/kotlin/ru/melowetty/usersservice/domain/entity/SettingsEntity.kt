package ru.melowetty.usersservice.domain.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.OneToOne
import jakarta.persistence.Table

@Entity
@Table(name = "settings")
open class SettingsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    open var id: Long? = null

    @OneToOne
    @JoinColumn(name = "owner_id", nullable = false)
    open lateinit var owner: UserEntity

    @Column(name = "user_group", nullable = false)
    open lateinit var group: String

    @Column(name = "user_sub_group", nullable = false)
    open var subGroup: Int = 0

    @Column(name = "is_enabled_new_schedule_notification", columnDefinition = "BOOLEAN DEFAULT true", nullable = false)
    open var isEnabledNewScheduleNotifications: Boolean = true

    @Column(name = "is_enabled_changed_schedule_notification", columnDefinition = "BOOLEAN DEFAULT true", nullable = false)
    open var isEnabledChangedScheduleNotifications: Boolean = true

    @Column(name = "is_enabled_coming_lessons_notifications", columnDefinition = "BOOLEAN DEFAULT false", nullable = false)
    open var isEnabledComingLessonsNotifications: Boolean = false
}