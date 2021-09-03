package com.dms.pms.domain.user.application

import com.dms.pms.domain.user.domain.User
import com.dms.pms.domain.user.domain.UserRepository
import com.dms.pms.domain.user.exception.UserAlreadyExistException
import com.dms.pms.domain.user.presentation.dto.RegisterDto
import spock.lang.Specification

class RegisterServiceTest extends Specification {
    def userRepository = Mock(UserRepository)
    def registerService = new RegisterService(userRepository)

    def "test register service with qualified all condition"() {
        given:
        RegisterDto.Request request = new RegisterDto.Request("test@gmail.com", "11111111", "tester")
        1 * userRepository.findByEmail(request.email) >> null

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
