package com.dms.pms.domain.user.`interface`

import com.dms.pms.domain.user.domain.User

interface UserFacade {
    fun getUserByEmail(email: String): User
}