package com.dms.pms.domain.notification.exception

import com.dms.pms.global.error.BusinessException
import com.dms.pms.global.error.ErrorCode

class MessageSendFailedException private constructor(): BusinessException(ErrorCode.MESSAGE_SEND_FAILED) {
    companion object {
        @JvmField
        val EXCEPTION = MessageSendFailedException()
    }
}