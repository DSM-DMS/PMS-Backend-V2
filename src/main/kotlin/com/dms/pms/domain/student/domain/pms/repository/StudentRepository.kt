package com.dms.pms.domain.student.domain.pms.repository

import com.dms.pms.domain.student.domain.pms.Student
import org.springframework.data.jpa.repository.JpaRepository

interface StudentRepository : JpaRepository<Student, Long> {
    fun findByStudentNumber(number: Long): Student?
}