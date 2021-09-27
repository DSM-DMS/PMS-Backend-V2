package com.dms.pms.domain.user.exception

import com.dms.pms.global.error.BusinessException
import com.dms.pms.global.error.ErrorCode

class InvalidTokenUser private constructor() : BusinessException(ErrorCode.USER_TOKEN_INVALID) {
    companion object {
        @JvmField
        val EXCEPTION = InvalidTokenUser()
    }
}