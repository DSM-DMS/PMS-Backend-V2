package com.dms.pms.global.security.exception

import com.dms.pms.global.error.BusinessException
import com.dms.pms.global.error.ErrorCode

class ExpiredTokenException {
    companion object {
        @JvmField
        val EXCEPTION = BusinessException(ErrorCode.EXPIRED_TOKEN)
    }
}