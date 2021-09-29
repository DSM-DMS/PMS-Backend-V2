package com.dms.pms.domain.auth.util

import kotlin.random.Random

const val STRING_LENGTH = 10;
private val charPool : List<Char> = ('a'..'z') + ('A'..'Z') + ('0'..'9')

fun generateRandomPassword(): String {
    return (1..STRING_LENGTH)
        .map { Random.nextInt(0, charPool.size) }
        .map (charPool::get)
        .joinToString("")
}