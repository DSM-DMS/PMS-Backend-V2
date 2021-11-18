package com.dms.pms.global.security.entrypoint

import com.dms.pms.global.security.exception.AccessDeniedException
import org.springframework.security.core.AuthenticationException
import org.springframework.security.web.AuthenticationEntryPoint
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class CustomAuthenticationEntryPoint : AuthenticationEntryPoint {
    override fun commence(
        request: HttpServletRequest,
        response: HttpServletResponse,
        authException: AuthenticationException?
    ) {
        throw AccessDeniedException.EXCEPTION
    }
}