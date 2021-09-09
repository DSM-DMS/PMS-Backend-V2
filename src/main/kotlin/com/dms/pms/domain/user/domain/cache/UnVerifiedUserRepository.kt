package com.dms.pms.domain.user.cache

import org.springframework.data.repository.CrudRepository

interface UnVerifiedUserRepository : CrudRepository<UnVerifiedUser, String>