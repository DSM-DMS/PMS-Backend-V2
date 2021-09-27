package com.dms.pms.domain.student.domain.pms.repository

import com.dms.pms.domain.student.domain.pms.Student

interface StudentUserRepositoryCustom {
    fun deleteStudent(email: String, number: Long)
    fun isUserHasStudent(email: String, number: Long): Boolean
    fun findAllStudentsByEmail(email: String): List<Student>
}