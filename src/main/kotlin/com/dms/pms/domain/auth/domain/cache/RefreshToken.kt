package com.dms.pms.domain.auth.domain.cache

import org.springframework.data.annotation.Id
import org.springframework.data.redis.core.RedisHash

@RedisHash(value = "RefreshToken", timeToLive = 60 * 60 * 2)
class RefreshToken (
    @Id
    var email: String,

    var refreshToken: String
)