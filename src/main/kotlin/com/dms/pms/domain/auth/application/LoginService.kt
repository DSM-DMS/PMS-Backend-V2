package com.dms.pms.domain.auth.application

import com.dms.pms.domain.auth.exception.PasswordNotMatchException
import com.dms.pms.domain.auth.presentation.dto.LoginDto
import com.dms.pms.domain.user.`interface`.UserFacade
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class LoginService (
    private val userFacade: UserFacade,
    private val passwordEncoder: PasswordEncoder
) {
    fun login(request: LoginDto.Request): LoginDto.Response {
        val user = userFacade.getUserByEmail(request.email)

        if (!passwordEncoder.matches(request.password, user.password)) {
            throw PasswordNotMatchException()
        }


    }
}