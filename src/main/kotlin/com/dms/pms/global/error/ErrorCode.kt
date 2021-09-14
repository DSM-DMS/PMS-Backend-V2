package com.dms.pms.global.error

enum class ErrorCode (
    val status: Int,
    val message: String
) {
    // Validation error codes
    INVALID_INPUT_VALUE(400, "Method argument is not valid"),
    INVALID_INPUT_TYPE(400, "Method argument type is not valid"),

    // User error codes
    USER_TOKEN_INVALID(401, "Invalid user token"),
    USER_NOT_FOUND(404, "User not found"),
    USER_ALREADY_EXIST(409, "User is already exist"),

    // Auth error codes
    EXPIRED_TOKEN(401, "Token is expired"),
    INVALID_TOKEN(401, "token is not valid"),
    PASSWORD_NOT_MATCHED(401, "Password is not matched"),

    // Student error codes
    STUDENT_NOT_FOUND(404, "Student is not found"),

    // Path not found
    PATH_NOT_FOUND(404, "404: Not found"),

    // Server Error
    INTERNAL_SERVER_ERROR(500, "Something went wrong")
}