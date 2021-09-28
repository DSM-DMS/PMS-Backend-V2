package com.dms.pms.domain.student.`interface`

import com.dms.pms.domain.student.domain.pms.Student
import com.dms.pms.domain.student.domain.pms.repository.StudentRepository
import com.dms.pms.domain.student.domain.pms.repository.StudentUserRepository
import com.dms.pms.domain.student.exception.StudentNotFoundException
import com.dms.pms.domain.student.exception.UserHasNotStudentException
import org.springframework.stereotype.Component

@Component
class StudentFacadeImpl (
    private val studentRepository: StudentRepository,
    private val studentUserRepository: StudentUserRepository
) : StudentFacade {

    override fun findStudentIdByNumber(number: Long): String {
        val student = studentRepository.findByStudentNumber(number)
            ?: throw StudentNotFoundException.EXCEPTION

        return student.studentId
    }

    override fun findAllStudentsByEmail(email: String): List<Student> {
        return studentUserRepository.findAllStudentsByEmail(email)
    }

    override fun checkIsUserHasStudentAndGetId(email: String, number: Long): String {
        val student = studentRepository.findByStudentNumber(number)
            ?: throw StudentNotFoundException.EXCEPTION

        if (!studentUserRepository.isUserHasStudent(email, student.studentCode))
            throw UserHasNotStudentException.EXCEPTION

        return student.studentId
    }
}