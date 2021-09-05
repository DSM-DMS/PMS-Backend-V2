package com.dms.pms.global.security

import com.dms.pms.domain.user.`interface`.UserFacade
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Component

@Component
class AuthDetailsService (
    private val userFacade: UserFacade
) : UserDetailsService {
    override fun loadUserByUsername(email: String): UserDetails {
        val user = userFacade.getUserByEmail(email)

        return AuthDetails(user)
    }
}