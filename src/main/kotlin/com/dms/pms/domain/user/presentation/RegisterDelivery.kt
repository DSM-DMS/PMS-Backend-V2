package com.dms.pms.domain.user.presentation

import com.dms.pms.domain.user.application.RegisterService
import com.dms.pms.domain.user.application.UserService
import com.dms.pms.domain.user.presentation.dto.RegisterDto
import com.dms.pms.domain.user.presentation.dto.StudentListDto
import com.dms.pms.global.security.UserInfo
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

import javax.validation.Valid

@RestController
@RequestMapping("/user")
class RegisterDelivery(
    private val registerService: RegisterService,
) {
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun register(@RequestBody @Valid request: RegisterDto.Request) = registerService.register(request)

    @GetMapping("/verify")
    fun verify(@RequestParam("token") token: String) = registerService.verify(token)
}