package com.dms.pms.domain.auth.presentation

import com.dms.pms.domain.auth.application.LoginService
import com.dms.pms.domain.auth.presentation.dto.LoginDto
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("/auth")
class AuthDelivery (
    private val loginService: LoginService
) {
    @PostMapping
    fun login(@RequestBody @Valid request: LoginDto.Request): LoginDto.Response = loginService.login(request)
}