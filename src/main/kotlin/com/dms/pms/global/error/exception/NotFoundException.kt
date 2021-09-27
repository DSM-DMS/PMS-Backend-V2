package com.dms.pms.global.error.exception

import com.dms.pms.global.error.BusinessException
import com.dms.pms.global.error.ErrorCode

class NotFoundException private constructor() : BusinessException(ErrorCode.PATH_NOT_FOUND) {
    companion object {
        @JvmField
        val EXCEPTION = NotFoundException()
    }
}