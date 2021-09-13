package com.dms.pms.global.error.exception

import com.dms.pms.global.error.BusinessException
import com.dms.pms.global.error.ErrorCode

class NotFoundException {
    companion object {
        @JvmField
        val EXCEPTION = BusinessException(ErrorCode.PATH_NOT_FOUND)
    }
}