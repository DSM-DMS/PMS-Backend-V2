package com.dms.pms.domain.user.application

import com.dms.pms.domain.user.domain.User
import com.dms.pms.domain.user.domain.UserRepository
import com.dms.pms.domain.user.domain.types.AuthProvider
import com.dms.pms.domain.user.domain.types.RoleType
import com.dms.pms.domain.user.exception.UserAlreadyExistException
import com.dms.pms.domain.user.presentation.dto.RegisterDto
import mu.KLogging
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class RegisterService(
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder
) {
    fun register(request: RegisterDto.Request) {
        userRepository.findByEmail(request.email) ?: return run {
            userRepository.save(
                User(
                    email = request.email,
                    password = passwordEncoder.encode(request.password),
                    name = request.name,
                    roleType = RoleType.USER,
                    provider = AuthProvider.LOCAL
                )
            )
        }

        throw UserAlreadyExistException.EXCEPTION
    }
}