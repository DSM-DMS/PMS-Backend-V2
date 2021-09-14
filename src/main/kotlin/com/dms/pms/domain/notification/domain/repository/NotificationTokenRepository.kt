package com.dms.pms.domain.notification.domain.repository

import com.dms.pms.domain.notification.domain.cache.NotificationToken
import org.springframework.data.repository.CrudRepository

interface NotificationTokenRepository : CrudRepository<NotificationToken, String>