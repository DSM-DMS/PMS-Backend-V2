package com.dms.pms.domain.point.exception

import com.dms.pms.global.error.BusinessException
import com.dms.pms.global.error.ErrorCode

class PointHistoryNotFoundException private constructor() : BusinessException(ErrorCode.POINT_HISTORY_NOT_FOUND) {
    companion object {
        @JvmField
        val EXCEPTION = PointHistoryNotFoundException()
    }
}