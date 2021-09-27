package com.dms.pms.domain.user.presentation

import com.dms.pms.domain.user.application.UserService
import com.dms.pms.domain.user.presentation.dto.StudentListDto
import com.dms.pms.global.security.UserInfo
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/user")
class UserDelivery (
    private val userService: UserService
) {

    @GetMapping
    fun getStudentList(@UserInfo email: String): StudentListDto.Response = userService.getStudentList(email)

}