package com.dms.pms.global.security.exception

import com.dms.pms.global.error.BusinessException
import com.dms.pms.global.error.ErrorCode

class InvalidTokenException {
    companion object {
        @JvmField
        val EXCEPTION = BusinessException(ErrorCode.INVALID_TOKEN)
    }
}