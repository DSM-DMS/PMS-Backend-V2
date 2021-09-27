package com.dms.pms.domain.student.domain.dms.repository

import com.dms.pms.domain.student.domain.dms.Student

interface DMSStudentRepositoryCustom {
    fun findByIdEager(studentId: String): Student
}