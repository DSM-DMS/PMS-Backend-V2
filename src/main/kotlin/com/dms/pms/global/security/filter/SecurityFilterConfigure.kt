package com.dms.pms.global.security.filter

import com.dms.pms.global.error.HandleExceptionFilter
import org.springframework.security.config.annotation.SecurityConfigurerAdapter
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.web.DefaultSecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter

class SecurityFilterConfigure (
    private val jwtTokenFilter: JwtTokenFilter,
    private val exceptionFilter: HandleExceptionFilter
) : SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity>() {
    override fun configure(builder: HttpSecurity) {
        builder.addFilterBefore(jwtTokenFilter, UsernamePasswordAuthenticationFilter::class.java)
        builder.addFilterBefore(exceptionFilter, JwtTokenFilter::class.java)
    }
}