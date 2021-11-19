package com.dms.pms.global.error.exception

import com.dms.pms.global.error.BusinessException
import com.dms.pms.global.error.ErrorCode

class MessageNotReadableException : BusinessException(ErrorCode.MESSAGE_NOT_READABLE) {
    companion object {
        @JvmField
        val EXCEPTION = MessageNotReadableException()
    }
}