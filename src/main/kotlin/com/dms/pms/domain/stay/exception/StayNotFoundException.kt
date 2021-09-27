package com.dms.pms.domain.stay.exception

import com.dms.pms.global.error.BusinessException
import com.dms.pms.global.error.ErrorCode

class StayNotFoundException private constructor() : BusinessException(ErrorCode.STAY_STATUS_NOT_FOUND) {
    companion object {
        @JvmField
        val EXCEPTION = StayNotFoundException()
    }
}