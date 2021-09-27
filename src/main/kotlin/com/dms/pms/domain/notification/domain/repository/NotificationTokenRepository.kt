package com.dms.pms.domain.notification.domain.repository

import com.dms.pms.domain.notification.domain.NotificationToken
import org.springframework.data.jpa.repository.JpaRepository

interface NotificationTokenRepository : JpaRepository<NotificationToken, String>