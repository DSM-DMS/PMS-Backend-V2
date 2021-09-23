package com.dms.pms.domain.student.domain.repository

import com.dms.pms.domain.student.domain.QStudentUser.studentUser
import com.dms.pms.domain.student.domain.StudentUser
import com.dms.pms.domain.student.domain.types.StudentUserKey
import com.dms.pms.global.querydsl.PMSQueryDslRepositorySupport

class StudentUserRepositoryImpl : PMSQueryDslRepositorySupport(StudentUser::class.java), StudentUserRepositoryCustom {
    override fun isUserHasStudent(email: String, number: Long): Boolean {
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