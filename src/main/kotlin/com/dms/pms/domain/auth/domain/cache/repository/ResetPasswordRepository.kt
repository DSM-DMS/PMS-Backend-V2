package com.dms.pms.domain.auth.domain.cache.repository

import com.dms.pms.domain.auth.domain.cache.ResetPassword
import org.springframework.data.repository.CrudRepository

interface ResetPasswordRepository : CrudRepository<ResetPassword, String> {
    fun findByToken(token: String): ResetPassword?
}