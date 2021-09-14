package com.dms.pms.domain.notification.domain.cache

import org.springframework.data.redis.core.RedisHash
import javax.persistence.Id

@RedisHash(value = "NotificationToken")
class NotificationToken (
    @Id
    var email: String,
    var token: String
)