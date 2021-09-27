package com.dms.pms.domain.auth.exception

import com.dms.pms.global.error.BusinessException
import com.dms.pms.global.error.ErrorCode

class PasswordNotMatchException private constructor() : BusinessException(ErrorCode.PASSWORD_NOT_MATCHED) {
    companion object {
        @JvmField
        val EXCEPTION = BusinessException(ErrorCode.PASSWORD_NOT_MATCHED)
    }
}