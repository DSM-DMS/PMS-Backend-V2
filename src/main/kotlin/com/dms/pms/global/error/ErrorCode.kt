package com.dms.pms.global.error

enum class ErrorCode (
    val status: Int,
    val message: String
) {
    // Validation error codes
    INVALID_INPUT_VALUE(400, "Method argument is not valid"),
    INVALID_INPUT_TYPE(400, "Method argument type is not valid"),

    // User error codes
    USER_NOT_FOUND(404, "User not found"),
    USER_ALREADY_EXIST(409, "User is already exist"),

    // Auth error codes
    PASSWORD_NOT_MATCHED(401, "Password is not matched")
}