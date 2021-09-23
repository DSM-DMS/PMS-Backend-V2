package com.dms.pms.domain.student.domain.repository

interface StudentUserRepositoryCustom {
    fun deleteStudent(email: String, number: Long)
    fun isUserHasStudent(email: String, number: Long): Boolean
}