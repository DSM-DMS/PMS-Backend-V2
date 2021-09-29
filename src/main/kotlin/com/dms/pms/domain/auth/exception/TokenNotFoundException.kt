package com.dms.pms.domain.auth.exception

import com.dms.pms.global.error.BusinessException
import com.dms.pms.global.error.ErrorCode

class TokenNotFoundException : BusinessException(ErrorCode.TOKEN_NOT_FOUND) {
    companion object {
        @JvmField
        val EXCEPTION = TokenNotFoundException()
    }
}