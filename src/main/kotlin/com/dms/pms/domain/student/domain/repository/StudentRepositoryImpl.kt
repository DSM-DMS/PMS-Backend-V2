package com.dms.pms.domain.student.domain.repository

import com.dms.pms.domain.student.domain.QStudentUser.studentUser
import com.dms.pms.domain.student.domain.StudentUser
import com.dms.pms.domain.student.domain.types.StudentUserKey
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport

class StudentRepositoryImpl : QuerydslRepositorySupport(StudentUser::class.java), StudentRepositoryCustom {

    override fun existsStudent(email: String, number: Long): Boolean {
        val studentUser = from(studentUser)
            .where(studentUser.studentUserKey.eq(StudentUserKey(email, number)))
            .fetchFirst()

        return studentUser != null
    }

    override fun deleteStudent(email: String, number: Long) {
        delete(studentUser)
            .where(studentUser.studentUserKey.eq(StudentUserKey(email, number)))
    }
}