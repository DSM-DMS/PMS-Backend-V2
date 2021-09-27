package com.dms.pms.domain.student.domain.dms.repository

import com.dms.pms.domain.student.domain.dms.Student
import org.springframework.data.jpa.repository.JpaRepository

interface DMSStudentRepository : JpaRepository<Student, String>, DMSStudentRepositoryCustom