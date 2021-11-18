package com.dms.pms.global.security.exception

import com.dms.pms.global.error.BusinessException
import com.dms.pms.global.error.ErrorCode

class AuthEntryPointException : BusinessException(ErrorCode.AUTHENTICATION_NEED) {
    companion object {
        @JvmField
        val EXCEPTION = AuthEntryPointException()
    }
}