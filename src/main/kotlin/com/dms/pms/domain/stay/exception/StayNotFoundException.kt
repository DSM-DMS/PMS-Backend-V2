package com.dms.pms.domain.stay.exception

import com.dms.pms.global.error.BusinessException
import com.dms.pms.global.error.ErrorCode

class StayNotFoundException {
    companion object {
        @JvmField
        val EXCEPTION = BusinessException(ErrorCode.STAY_STATUS_NOT_FOUND)
    }
}