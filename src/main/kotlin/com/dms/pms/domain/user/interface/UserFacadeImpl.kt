package com.dms.pms.domain.user.`interface`

import com.dms.pms.domain.user.domain.User
import com.dms.pms.domain.user.domain.UserRepository
import com.dms.pms.domain.user.exception.UserNotFoundException

class UserFacadeImpl (
    private val userRepository: UserRepository
) : UserFacade {
    override fun getUserByEmail(email: String): User  {
        return userRepository.findByEmail(email) ?: throw UserNotFoundException()
    }
}