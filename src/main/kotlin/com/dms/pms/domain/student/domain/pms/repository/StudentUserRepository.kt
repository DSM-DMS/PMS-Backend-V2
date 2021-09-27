package com.dms.pms.domain.student.domain.pms.repository

import com.dms.pms.domain.student.domain.pms.StudentUser
import com.dms.pms.domain.student.domain.types.StudentUserKey
import org.springframework.data.jpa.repository.JpaRepository

interface StudentUserRepository : JpaRepository<StudentUser, StudentUserKey>, StudentUserRepositoryCustom