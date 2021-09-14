package com.dms.pms.domain.student.domain.repository

import com.dms.pms.domain.student.domain.Student
import org.springframework.data.jpa.repository.JpaRepository

interface StudentRepository : JpaRepository<Student, Long>, StudentRepositoryCustom