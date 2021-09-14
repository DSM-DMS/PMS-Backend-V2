package com.dms.pms.domain.user.domain.cache

import org.springframework.data.repository.CrudRepository

interface UnVerifiedUserRepository : CrudRepository<UnVerifiedUser, String>