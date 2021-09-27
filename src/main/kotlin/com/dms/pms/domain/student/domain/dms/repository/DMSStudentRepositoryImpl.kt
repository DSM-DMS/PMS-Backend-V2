package com.dms.pms.domain.student.domain.dms.repository

import com.dms.pms.domain.point.domain.QPoint.point
import com.dms.pms.domain.stay.domain.QStay.stay
import com.dms.pms.domain.student.domain.dms.Student
import com.dms.pms.domain.student.exception.StudentNotFoundException
import com.dms.pms.domain.student.domain.dms.QStudent.student
import com.dms.pms.global.querydsl.DMSQueryDslRepositorySupport

class DMSStudentRepositoryImpl : DMSQueryDslRepositorySupport(Student::class.java), DMSStudentRepositoryCustom {
    override fun findByIdEager(studentId: String): Student {
        val student = from(student)
            .innerJoin(student.point, point)
            .innerJoin(student.stay, stay)
            .fetchJoin()
            .fetchFirst()

        return student ?: throw StudentNotFoundException.EXCEPTION
    }
}