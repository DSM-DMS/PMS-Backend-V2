package com.dms.pms

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cache.annotation.EnableCaching

@SpringBootApplication
@EnableCaching
class PmsApplication

fun main(args: Array<String>) {
    runApplication<PmsApplication>(*args)
}
