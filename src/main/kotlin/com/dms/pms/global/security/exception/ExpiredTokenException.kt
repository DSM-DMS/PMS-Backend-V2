package com.dms.pms.global.security.exception

import com.dms.pms.global.error.BusinessException
import com.dms.pms.global.error.ErrorCode

class ExpiredTokenException private constructor() : BusinessException(ErrorCode.EXPIRED_TOKEN) {
    companion object {
        @JvmField
        val EXCEPTION = ExpiredTokenException()
    }
}