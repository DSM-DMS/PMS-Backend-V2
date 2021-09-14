package com.dms.pms.domain.student.domain.repository

interface StudentRepositoryCustom {
    fun existsStudent(email: String, number: Long): Boolean
    fun deleteStudent(email: String, number: Long)
}