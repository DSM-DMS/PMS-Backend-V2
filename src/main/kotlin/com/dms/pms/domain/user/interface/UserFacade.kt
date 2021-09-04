package com.dms.pms.domain.user.`interface`

import com.dms.pms.domain.user.domain.User
import org.springframework.stereotype.Component

@Component
interface UserFacade {
    fun getUserByEmail(email: String): User
}