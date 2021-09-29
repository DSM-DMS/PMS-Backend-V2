package com.dms.pms.domain.auth.domain.cache.repository

import com.dms.pms.domain.auth.domain.cache.RefreshToken
import org.springframework.data.repository.CrudRepository

interface RefreshTokenRepository : CrudRepository<RefreshToken, String>