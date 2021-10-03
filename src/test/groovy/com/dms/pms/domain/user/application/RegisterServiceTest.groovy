package com.dms.pms.domain.user.application

import com.dms.pms.domain.user.domain.User
import com.dms.pms.domain.user.domain.cache.UnVerifiedUser
import com.dms.pms.domain.user.domain.cache.UnVerifiedUserRepository
import com.dms.pms.domain.user.domain.repository.UserRepository
import com.dms.pms.domain.user.domain.types.AuthProvider
import com.dms.pms.domain.user.domain.types.RoleType
import com.dms.pms.domain.user.exception.UserAlreadyExistException
import com.dms.pms.domain.user.presentation.dto.RegisterDto
import com.dms.pms.global.error.BusinessException
import com.dms.pms.infrastructure.ses.SESService
import com.dms.pms.infrastructure.ses.SESTemplateType
import org.springframework.security.crypto.password.PasswordEncoder
import spock.lang.Specification

class RegisterServiceTest extends Specification {
    def userRepository = Mock(UserRepository)
    def passwordEncoder = Mock(PasswordEncoder)
    def sesService = Mock(SESService)
    def unverifiedUserRepository = Mock(UnVerifiedUserRepository)
    def registerService = new RegisterService(userRepository, unverifiedUserRepository, sesService, passwordEncoder, "test.com")

    def "test register service with qualified all condition"() {
        given:
        RegisterDto.Request request = new RegisterDto.Request("test@gmail.com", "11111111", "tester")

        when:
        registerService.register(request)

        then:
        1 * userRepository.findById(request.email) >> Optional.empty()
        passwordEncoder.encode(request.password) >> request.password
        unverifiedUserRepository.save() >> new UnVerifiedUser("test_token", request.email, request.password, request.name)

        noExceptionThrown()
    }

    def "test register service with exists user information"() {
        given:
        RegisterDto.Request request = new RegisterDto.Request("test@gmail.com", "11111111", "tester")

        when:
        registerService.register(request)

        then:
        1 * userRepository.findById(request.email)
                >> Optional.of(new User("asdf", "asdf", "asdf", RoleType.USER, AuthProvider.LOCAL, []))
        thrown(UserAlreadyExistException)
    }
}
