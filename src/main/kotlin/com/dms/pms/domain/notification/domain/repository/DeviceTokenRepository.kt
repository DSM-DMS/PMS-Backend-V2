package com.dms.pms.domain.notification.domain.repository

import com.dms.pms.domain.notification.domain.DeviceToken
import org.springframework.data.jpa.repository.JpaRepository

interface DeviceTokenRepository : JpaRepository<DeviceToken, Long> {
    fun deleteAllByToken(token: String)
}