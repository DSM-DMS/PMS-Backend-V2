package com.dms.pms.domain.auth.application

import com.dms.pms.domain.auth.domain.cache.RefreshToken
import com.dms.pms.domain.auth.domain.cache.ResetPassword
import com.dms.pms.domain.auth.domain.cache.repository.RefreshTokenRepository
import com.dms.pms.domain.auth.domain.cache.repository.ResetPasswordRepository
import com.dms.pms.domain.auth.exception.PasswordNotMatchException
import com.dms.pms.domain.auth.exception.TokenNotFoundException
import com.dms.pms.domain.auth.presentation.dto.ChangePasswordDto
import com.dms.pms.domain.auth.presentation.dto.LoginDto
import com.dms.pms.domain.auth.presentation.dto.ResetPasswordDto
import com.dms.pms.domain.auth.presentation.dto.ResetPasswordTokenDto
import com.dms.pms.domain.auth.util.generateRandomPassword
import com.dms.pms.domain.user.`interface`.UserFacade
import com.dms.pms.global.security.jwt.JwtTokenProvider
import com.dms.pms.infrastructure.ses.SESService
import com.dms.pms.infrastructure.ses.SESTemplateType
import org.springframework.beans.factory.annotation.Value
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Isolation
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
class LoginService (
    private val userFacade: UserFacade,
    private val jwtTokenProvider: JwtTokenProvider,
    private val refreshTokenRepository: RefreshTokenRepository,
    private val resetPasswordRepository: ResetPasswordRepository,
    private val passwordEncoder: PasswordEncoder,
    private val sesService: SESService,

    @Value("\${domain.http-name}") private val domainName: String
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

    fun resetPassword(request: ResetPasswordDto.Request) {
        val token = UUID.randomUUID().toString()

        resetPasswordRepository.save(
            ResetPassword(
                email = request.email,
                token = token
            )
        )

        sesService.send(
            listOf(request.email),
            SESTemplateType.PASSWORD_RESET.templateName,
            mapOf(
                "user_name" to request.email,
                "verify_url" to "$domainName/auth/password/reset?token=$token"
            )
        )
    }

    @Transactional(isolation = Isolation.REPEATABLE_READ)
    fun resetPasswordToken(token: String): ResetPasswordTokenDto.Response {
        val resetPassword = resetPasswordRepository.findByToken(token)
            ?: throw TokenNotFoundException.EXCEPTION

        val user = userFacade.getUserByEmail(resetPassword.email)

        val password = generateRandomPassword()
        user.changePassword(password)

        resetPasswordRepository.delete(resetPassword)

        return ResetPasswordTokenDto.Response(password)
    }
}