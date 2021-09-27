package com.dms.pms.global.error.exception

import com.dms.pms.global.error.BusinessException
import com.dms.pms.global.error.ErrorCode

class MethodArgumentException private constructor() : BusinessException(ErrorCode.INVALID_INPUT_VALUE) {
    companion object {
        @JvmField
        val EXCEPTION = MethodArgumentException()
    }
}