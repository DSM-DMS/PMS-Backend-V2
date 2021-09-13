package com.dms.pms.domain.student.domain.repository

import com.dms.pms.domain.student.domain.StudentUser
import com.dms.pms.domain.student.domain.types.StudentUserKey
import org.springframework.data.jpa.repository.JpaRepository

interface StudentUserRepository : JpaRepository<StudentUser, StudentUserKey>