package com.dms.pms.domain.auth.domain.cache

import org.springframework.data.redis.core.RedisHash
import javax.persistence.Column
import javax.persistence.Id

@RedisHash(value = "ResetPassword", timeToLive = 60 * 60 * 2)
class ResetPassword (
    @Id
    var email: String,

    @Column(unique = true)
    var token: String
)