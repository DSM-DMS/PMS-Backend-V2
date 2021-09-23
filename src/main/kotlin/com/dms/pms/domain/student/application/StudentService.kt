package com.dms.pms.domain.student.application

import com.dms.pms.domain.meal.`interface`.MealFacade
import com.dms.pms.domain.point.`interface`.PointFacade
import com.dms.pms.domain.stay.`interface`.StayFacade
import com.dms.pms.domain.student.domain.StudentUser
import com.dms.pms.domain.student.domain.repository.StudentRepository
import com.dms.pms.domain.student.domain.repository.StudentUserUserRepository
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
    private val studentUserRepository: StudentUserUserRepository,
    private val pointFacade: PointFacade,
    private val stayFacade: StayFacade,
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
        if (!studentUserRepository.isUserHasStudent(email, request.number))
            throw UserHasNotStudentException.EXCEPTION

        studentUserRepository.deleteStudent(email, request.number)

        return DeleteStudentDto.Response("student is successfully deleted.")
    }

    fun getStudentInfo(number: Long, email: String): StudentInfoDto.Response {
        val student = studentRepository.findByStudentNumber(number)
            ?: throw StudentNotFoundException.EXCEPTION

        if (studentUserRepository.isUserHasStudent(email, number))
            throw UserHasNotStudentException.EXCEPTION

        val point = pointFacade.getPointByStudentId(student.studentId)

        return StudentInfoDto.Response(
            bonusPoint = point.bonusPoint,
            minusPoint = point.minusPoint,
            stay = stayFacade.getStayValueByStudentId(student.studentId),
            mealApply = mealFacade.getMealApplyStatus(student.studentId)
        )
    }
}