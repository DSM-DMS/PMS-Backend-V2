package com.dms.pms.global.security.exception

import com.dms.pms.global.error.BusinessException
import com.dms.pms.global.error.ErrorCode

class AccessDeniedException : BusinessException(ErrorCode.INSUFFICIENT_PERMISSION) {
    companion object {
        @JvmField
        val EXCEPTION = AccessDeniedException()
    }
}