package com.dms.pms.global.error

import com.dms.pms.global.error.exception.InternalErrorException
import com.dms.pms.global.error.exception.MethodArgumentException
import com.dms.pms.global.error.exception.NotFoundException
import org.springframework.stereotype.Component
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.filter.OncePerRequestFilter
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException
import org.springframework.web.servlet.NoHandlerFoundException
import org.springframework.web.util.NestedServletException
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Component
class HandleExceptionFilter : OncePerRequestFilter() {

    companion object KLogger

    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        return try {
            filterChain.doFilter(request, response)
        } catch (e: Exception) {

            val exception = if (e is NestedServletException) e.cause else e

            logger.error("[ERROR] IP ${request.remoteAddr} - Error occurred by $exception")

            when (exception) {
                // BusinessException
                is BusinessException -> writeErrorCodes(exception, response)

                // Exception for Method Arguments
                is MethodArgumentNotValidException,
                is MethodArgumentTypeMismatchException -> writeErrorCodes(MethodArgumentException.EXCEPTION, response)

                // 404 Not Found
                is NoHandlerFoundException -> writeErrorCodes(NotFoundException.EXCEPTION, response)

                // Or Else
                else -> writeErrorCodes(InternalErrorException.EXCEPTION, response)
            }
        }
    }

    private fun writeErrorCodes(e: BusinessException, response: HttpServletResponse) {
        val errorCode = e.code
        val errorResponse = ErrorResponse.of(errorCode)

        response.contentType = "application/json"
        response.status = errorCode.status
        response.writer.write(errorResponse.toString())
    }
}