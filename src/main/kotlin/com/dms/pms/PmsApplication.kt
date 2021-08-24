package com.dms.pms

import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class PmsApplication

fun main(args: Array<String>) {
    runApplication<PmsApplication>(*args)
}
