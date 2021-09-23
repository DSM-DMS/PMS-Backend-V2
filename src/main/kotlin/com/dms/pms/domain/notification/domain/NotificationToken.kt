package com.dms.pms.domain.notification.domain

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "notification")
class NotificationToken (
    @Id
    var email: String,

    @Column(name = "notification_token")
    var token: String
)