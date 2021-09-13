package com.dms.pms.domain.student.presentation

import com.dms.pms.domain.student.application.StudentService
import com.dms.pms.domain.student.presentation.dto.AddStudentDto
import com.dms.pms.global.security.UserInfo
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
class StudentController(
    private val studentService: StudentService
) {
    @PostMapping("/user/student")
    fun addStudent(@RequestBody @Valid request: AddStudentDto.Request, @UserInfo email: String): AddStudentDto.Response {
        return studentService.addStudent(request, email)
    }


}