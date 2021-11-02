package com.dms.pms.domain.user.application

import com.dms.pms.domain.user.domain.User
import com.dms.pms.domain.user.domain.repository.UserRepository
import com.dms.pms.domain.user.domain.cache.UnVerifiedUser
import com.dms.pms.domain.user.domain.cache.UnVerifiedUserRepository
import com.dms.pms.domain.user.domain.types.AuthProvider
import com.dms.pms.domain.user.domain.types.RoleType
import com.dms.pms.domain.user.exception.InvalidTokenUserException
import com.dms.pms.domain.user.exception.UserAlreadyExistException
import com.dms.pms.domain.user.presentation.dto.RegisterDto
import com.dms.pms.domain.user.presentation.dto.VerifyDto
import com.dms.pms.infrastructure.ses.SESService
import com.dms.pms.infrastructure.ses.SESTemplateType
import org.springframework.beans.factory.annotation.Value
import org.springframework.data.repository.findByIdOrNull
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import java.util.*

@Service
class RegisterService(
    private val userRepository: UserRepository,
    private val unVerifiedUserRepository: UnVerifiedUserRepository,
    private val sesService: SESService,
    private val passwordEncoder: PasswordEncoder,

    @Value("\${domain.http-name}") private val domainName: String
) {

    fun register(request: RegisterDto.Request) {

        if (userRepository.findByIdOrNull(request.email) != null) {
            throw UserAlreadyExistException.EXCEPTION
        }

        val token = UUID.randomUUID().toString()

        unVerifiedUserRepository.save(
            UnVerifiedUser(
                verifyToken = token,
                email = request.email,
                password = passwordEncoder.encode(request.password),
                name = request.name
            )
        )

        sesService.send(
            listOf(request.email),
            SESTemplateType.REGISTER_VERIFY.templateName,
            mapOf(
                "user_name" to request.name,
                "verify_url" to "$domainName/user/verify?token=$token"
            )
        )
    }

    fun verify(token: String): VerifyDto.Response {
        val user = unVerifiedUserRepository.findByIdOrNull(token) ?: throw InvalidTokenUserException.EXCEPTION

        // Delete user from unVerifiedUser
        unVerifiedUserRepository.deleteById(token)

        // Adding user
        userRepository.save(
            User(
                email = user.email,
                password = user.password,
                name = user.name,
                roleType = RoleType.USER,
                provider = AuthProvider.LOCAL
            )
        )

        return VerifyDto.Response("Email verification success.")
    }
}