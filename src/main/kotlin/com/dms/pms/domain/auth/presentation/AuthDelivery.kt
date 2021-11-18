package com.dms.pms.domain.auth.presentation

import com.dms.pms.domain.auth.application.LoginService
import com.dms.pms.domain.auth.presentation.dto.ChangePasswordDto
import com.dms.pms.domain.auth.presentation.dto.LoginDto
import com.dms.pms.domain.auth.presentation.dto.ResetPasswordDto
import com.dms.pms.global.security.UserInfo
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/auth")
class AuthDelivery (
    private val loginService: LoginService
) {
    @PostMapping
    fun login(@RequestBody @Valid request: LoginDto.Request): LoginDto.Response = loginService.login(request)

    @PutMapping("/password")
    fun changePassword(@RequestBody @Valid request: ChangePasswordDto.Request, @UserInfo email: String) {
        loginService.changePassword(request, email)
    }

    @PostMapping("/password/reset")
    fun resetPassword(@RequestBody @Valid request: ResetPasswordDto.Request) {
        loginService.resetPassword(request)
    }

    @GetMapping("/password/reset")
    fun resetPasswordToken(@RequestParam("token") token: String) = loginService.resetPasswordToken(token)
}