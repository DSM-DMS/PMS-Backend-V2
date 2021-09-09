package com.dms.pms.domain.user.cache

import org.springframework.data.redis.core.RedisHash
import javax.persistence.Id

// Live for 30 minutes
@RedisHash(value = "UnVerifiedUser", timeToLive = 30 * 1000 * 60)
class UnVerifiedUser (
    @Id
    val verifyToken: String,

    val email: String,
    val password: String,
    val name: String
)