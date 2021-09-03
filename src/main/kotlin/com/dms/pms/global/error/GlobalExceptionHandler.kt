package com.dms.pms.global.error

import mu.KLogging
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException

@RestControllerAdvice
class GlobalExceptionHandler {
    companion object: KLogging()

    @ExceptionHandler(MethodArgumentNotValidException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun handleMethodArgumentInvalidException(e: MethodArgumentNotValidException): ErrorResponse {
        logger.error("Method Argument is not valid: ", e)

        return ErrorResponse.of(ErrorCode.INVALID_INPUT_VALUE)
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun handleMethodArgumentTypeMismatchException(e: MethodArgumentTypeMismatchException): ErrorResponse {
        logger.error("Method Argument type is not valid: ", e)

        return ErrorResponse.of(ErrorCode.INVALID_INPUT_VALUE)
    }

    @ExceptionHandler(BusinessException::class)
    fun handleBusinessException(e: BusinessException): ResponseEntity<ErrorResponse> {
        logger.error("BusinessException: ", e)

        return ResponseEntity.status(e.code.status).body(ErrorResponse.of(e.code))
    }
}