package com.dms.pms.global.security.jwt

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

@ConstructorBinding
@ConfigurationProperties(prefix = "auth.jwt")
data class JwtProperties (
    val secretKey: String,
    val accessExp: Long,
    val refreshExp: Long
)