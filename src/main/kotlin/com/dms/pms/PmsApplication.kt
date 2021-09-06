package com.dms.pms

import com.dms.pms.global.security.jwt.JwtProperties
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication
import org.springframework.cache.annotation.EnableCaching

@EnableCaching
@EnableConfigurationProperties(JwtProperties::class)
@SpringBootApplication
class PmsApplication

fun main(args: Array<String>) {
    runApplication<PmsApplication>(*args)
}
