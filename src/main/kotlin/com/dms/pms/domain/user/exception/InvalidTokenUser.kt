package com.dms.pms.domain.user.exception

import com.dms.pms.global.error.BusinessException
import com.dms.pms.global.error.ErrorCode

class InvalidTokenUser private constructor() {
    companion object {
        @JvmField
        val EXCEPTION = BusinessException(ErrorCode.USER_TOKEN_INVALID)
    }
}