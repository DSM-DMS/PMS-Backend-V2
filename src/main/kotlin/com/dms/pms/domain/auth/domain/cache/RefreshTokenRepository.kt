package com.dms.pms.domain.auth.domain.cache

import org.springframework.data.repository.CrudRepository

interface RefreshTokenRepository : CrudRepository<RefreshToken, String>