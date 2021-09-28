package com.dms.pms.domain.user.presentation

import com.dms.pms.domain.user.application.UserService
import com.dms.pms.domain.user.presentation.dto.ChangeNameDto
import com.dms.pms.domain.user.presentation.dto.StudentListDto
import com.dms.pms.global.security.UserInfo
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/user")
class UserDelivery (
    private val userService: UserService
) {

    @GetMapping
    fun getStudentList(@UserInfo email: String): StudentListDto.Response = userService.getStudentList(email)

    @PutMapping("/user/name")
    fun changeName(@RequestBody @Valid request: ChangeNameDto.Request, @UserInfo name: String) {
        userService.changeName(request, name)
    }

}