package com.dms.pms.global.error

enum class ErrorCode (
    val status: Int,
    val message: String
) {
    INVALID_INPUT_VALUE(400, "Method argument is not valid"),
    INVALID_INPUT_TYPE(400, "Method argument type is not valid"),

    USER_ALREADY_EXIST(409, "User is already exist")
}