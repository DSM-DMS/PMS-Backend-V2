package com.dms.pms.domain.user.presentation

import com.dms.pms.domain.user.application.RegisterService
import com.dms.pms.domain.user.presentation.dto.RegisterDto
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

import javax.validation.Valid

@RestController
@RequestMapping("/user")
class RegisterDelivery(
    private val service: RegisterService
) {
    @PostMapping
    fun register(@RequestBody @Valid request: RegisterDto.Request) = service.register(request)
}