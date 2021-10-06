package com.dms.pms.domain.student.application

import com.dms.pms.domain.meal.`interface`.MealFacade
import com.dms.pms.domain.point.`interface`.PointFacade
import com.dms.pms.domain.stay.`interface`.StayFacade
import com.dms.pms.domain.student.domain.dms.repository.DMSStudentRepository
import com.dms.pms.domain.student.domain.pms.StudentUser
import com.dms.pms.domain.student.domain.pms.repository.StudentRepository
import com.dms.pms.domain.student.domain.pms.repository.StudentUserRepository
import com.dms.pms.domain.student.domain.types.StudentUserKey
import com.dms.pms.domain.student.exception.StudentNotFoundException
import com.dms.pms.domain.student.exception.UserHasNotStudentException
import com.dms.pms.domain.student.presentation.dto.AddStudentDto
import com.dms.pms.domain.student.presentation.dto.DeleteStudentDto
import com.dms.pms.domain.student.presentation.dto.StudentInfoDto
import com.dms.pms.domain.user.`interface`.UserFacade
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
class StudentService(
    private val userFacade: UserFacade,
    private val studentRepository: StudentRepository,
    private val studentUserRepository: StudentUserRepository,
    private val dmsStudentRepository: DMSStudentRepository,
    private val mealFacade: MealFacade
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

    fun deleteStudent(request: DeleteStudentDto.Request, email: String): DeleteStudentDto.Response {

        val student = studentRepository.findByStudentNumber(request.number)
            ?: throw StudentNotFoundException.EXCEPTION

        if (!studentUserRepository.isUserHasStudent(email, student.studentCode))
            throw UserHasNotStudentException.EXCEPTION

        studentUserRepository.deleteStudent(email, student.studentNumber)

        return DeleteStudentDto.Response("student is successfully deleted.")
    }

    fun getStudentInfo(number: Long, email: String): StudentInfoDto.Response {

        val student = studentRepository.findByStudentNumber(number)
            ?: throw StudentNotFoundException.EXCEPTION

        if (!studentUserRepository.isUserHasStudent(email, student.studentCode))
            throw UserHasNotStudentException.EXCEPTION

        val studentId = student.studentId
        val dmsStudent = dmsStudentRepository.findByIdEager(studentId)

        return StudentInfoDto.Response(
            bonusPoint = dmsStudent.point.goodPoint,
            minusPoint = dmsStudent.point.badPoint,
            stay = dmsStudent.stay.value,
            mealApply = mealFacade.getMealApplyStatus(studentId)
        )
    }
}