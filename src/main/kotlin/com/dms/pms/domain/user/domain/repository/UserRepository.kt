package com.dms.pms.domain.user.domain.repository

import com.dms.pms.domain.user.domain.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, String>