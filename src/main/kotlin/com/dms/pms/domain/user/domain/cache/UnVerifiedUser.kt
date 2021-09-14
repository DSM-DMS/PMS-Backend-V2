package com.dms.pms.domain.user.domain.cache

import org.springframework.data.annotation.Id
import org.springframework.data.redis.core.RedisHash

// Live for 30 minutes
@RedisHash(value = "UnVerifiedUser", timeToLive = 60 * 30)
class UnVerifiedUser (
    @Id
    var verifyToken: String,

    var email: String,
    var password: String,
    var name: String
)