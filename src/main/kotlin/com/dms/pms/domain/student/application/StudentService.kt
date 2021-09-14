package com.dms.pms.domain.student.application

import com.dms.pms.domain.student.domain.StudentUser
import com.dms.pms.domain.student.domain.repository.StudentRepository
import com.dms.pms.domain.student.domain.repository.StudentUserRepository
import com.dms.pms.domain.student.domain.types.StudentUserKey
import com.dms.pms.domain.student.exception.StudentNotFoundException
import com.dms.pms.domain.student.presentation.dto.AddStudentDto
import com.dms.pms.domain.user.`interface`.UserFacade
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
class StudentService(
    private val userFacade: UserFacade,
    private val studentRepository: StudentRepository,
    private val studentUserRepository: StudentUserRepository
) {

    @Transactional
    fun addStudent(request: AddStudentDto.Request, email: String): AddStudentDto.Response {
        val user = userFacade.getUserByEmail(email)
        val student = studentRepository.findByIdOrNull(request.number) ?: throw StudentNotFoundException.EXCEPTION

        val studentUser = studentUserRepository.save(
            StudentUser(
                StudentUserKey(user.email, student.studentCode),
                user,
                student
            )
        )

        user.addStudent(studentUser)
        student.addUser(studentUser)

        return AddStudentDto.Response("student addition is success.")
    }
}