package com.dms.pms.domain.user.application

import com.dms.pms.domain.user.domain.User
import com.dms.pms.domain.user.domain.repository.UserRepository
import com.dms.pms.domain.user.exception.UserAlreadyExistException
import com.dms.pms.domain.user.presentation.dto.RegisterDto
import org.springframework.security.crypto.password.PasswordEncoder
import spock.lang.Specification

class RegisterServiceTest extends Specification {
    def userRepository = Mock(UserRepository)
    def passwordEncoder = Mock(PasswordEncoder)
    def registerService = new RegisterService(userRepository, passwordEncoder)

    def "test register service with qualified all condition"() {
        given:
        RegisterDto.Request request = new RegisterDto.Request("test@gmail.com", "11111111", "tester")
        1 * userRepository.findByEmail(request.email) >> null
        1 * passwordEncoder.encode(request.password) >> request.password

        when:
        registerService.register(request)

        then:
        noExceptionThrown()
    }

    def "test register service with exists user information"() {
        given:
        RegisterDto.Request request = new RegisterDto.Request("test@gmail.com", "11111111", "tester")
        1 * userRepository.findByEmail(request.email) >> new User()

        when:
        registerService.register(request)

        then:
        thrown(UserAlreadyExistException)
    }
}
