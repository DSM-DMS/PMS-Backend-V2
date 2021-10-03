package com.dms.pms.domain.outing.presentation

import com.dms.pms.domain.outing.application.OutingService
import com.dms.pms.domain.outing.presentation.dto.AddOutingDto
import com.dms.pms.domain.outing.presentation.dto.StudentOutingDto
import com.dms.pms.global.security.UserInfo
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
class OutingDelivery (
    private val outingService: OutingService
) {
    @GetMapping("/user/student/outing/{number}")
    fun getStudentOuting(@PathVariable("number") number: Long, @UserInfo email: String): StudentOutingDto.Response {
        return outingService.getStudentOutings(number, email)
    }

    @PostMapping("/student/outing")
    @ResponseStatus(HttpStatus.CREATED)
    fun addOuting(@RequestBody @Valid request: AddOutingDto.Request) = outingService.addOuting(request)

}