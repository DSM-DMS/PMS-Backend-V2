package com.dms.pms.global.error.exception

import com.dms.pms.global.error.BusinessException
import com.dms.pms.global.error.ErrorCode

class InternalErrorException {
    companion object {
        @JvmField
        val EXCEPTION = BusinessException(ErrorCode.INTERNAL_SERVER_ERROR)
    }
}