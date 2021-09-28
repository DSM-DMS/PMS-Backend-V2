package com.dms.pms.domain.auth.application

import com.dms.pms.domain.auth.domain.cache.RefreshToken
import com.dms.pms.domain.auth.domain.cache.RefreshTokenRepository
import com.dms.pms.domain.auth.exception.PasswordNotMatchException
import com.dms.pms.domain.auth.presentation.dto.ChangePasswordDto
import com.dms.pms.domain.auth.presentation.dto.LoginDto
import com.dms.pms.domain.user.`interface`.UserFacade
import com.dms.pms.global.security.jwt.JwtTokenProvider
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Isolation
import org.springframework.transaction.annotation.Transactional

@Service
class LoginService (
    private val userFacade: UserFacade,
    private val jwtTokenProvider: JwtTokenProvider,
    private val refreshTokenRepository: RefreshTokenRepository,
    private val passwordEncoder: PasswordEncoder
) {
    fun login(request: LoginDto.Request): LoginDto.Response {
        val user = userFacade.getUserByEmail(request.email)

        if (!passwordEncoder.matches(request.password, user.password)) {
            throw PasswordNotMatchException.EXCEPTION
        }

        val accessToken = jwtTokenProvider.generateAccessToken(user)
        val refreshToken = jwtTokenProvider.generateRefreshToken(user)

        refreshTokenRepository.save(
            RefreshToken(user.email, refreshToken)
        )

        return LoginDto.Response(accessToken, refreshToken)
    }

    @Transactional(isolation = Isolation.REPEATABLE_READ)
    fun changePassword(request: ChangePasswordDto.Request, email: String) {
        val user = userFacade.getUserByEmail(email)

        if (!passwordEncoder.matches(request.prePassword, user.password))
            throw PasswordNotMatchException.EXCEPTION

        user.changePassword(passwordEncoder.encode(request.password))
    }
}