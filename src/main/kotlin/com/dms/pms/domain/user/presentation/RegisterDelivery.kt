package com.dms.pms.domain.user.presentation

import com.dms.pms.domain.user.application.RegisterService
import com.dms.pms.domain.user.presentation.dto.RegisterDto
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

import javax.validation.Valid

@RestController
@RequestMapping("/user")
class RegisterDelivery(
    private val service: RegisterService
) {
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun register(@RequestBody @Valid request: RegisterDto.Request) = service.register(request)

    @GetMapping("/verify")
    fun verify(@RequestParam("token") token: String) = service.verify(token)
}