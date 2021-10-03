package com.dms.pms.domain.auth.domain.cache

import org.springframework.data.annotation.Id
import org.springframework.data.redis.core.RedisHash

@RedisHash(value = "ResetPassword", timeToLive = 60 * 60 * 2)
class ResetPassword (
    @Id
    var email: String,

    var token: String
)