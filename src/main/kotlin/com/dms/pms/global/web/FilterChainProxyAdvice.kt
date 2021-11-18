package com.dms.pms.global.web

import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.springframework.stereotype.Component
import java.util.concurrent.RejectedExecutionException
import javax.servlet.http.HttpServletResponse

@Aspect
@Component
class FilterChainProxyAdvice {
    @Around("execution(public void org.springframework.security.web.FilterChainProxy.doFilter(..))")
    fun handleRequestRejectedException(pjp: ProceedingJoinPoint) {
        try {
            pjp.proceed()
        } catch (exception: RejectedExecutionException) {
            val response = pjp.args[1] as HttpServletResponse
            response.sendError(HttpServletResponse.SC_BAD_REQUEST)
        }
    }
}