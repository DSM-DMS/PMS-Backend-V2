package com.dms.pms.global.security.filter

import com.dms.pms.global.error.BusinessException
import com.dms.pms.global.error.ErrorResponse
import com.dms.pms.global.error.exception.InternalErrorException
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Component
class HandleExceptionFilter : OncePerRequestFilter() {
    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        return try {
            filterChain.doFilter(request, response)
        } catch (e: Exception) {
            when (e) {
                is BusinessException -> writeErrorCodes(e, response)
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