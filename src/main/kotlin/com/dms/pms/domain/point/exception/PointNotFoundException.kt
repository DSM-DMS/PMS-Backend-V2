package com.dms.pms.domain.point.exception

import com.dms.pms.global.error.BusinessException
import com.dms.pms.global.error.ErrorCode

class PointNotFoundException : BusinessException(ErrorCode.POINT_NOT_FOUND) {
    companion object {
        @JvmField
        val EXCEPTION = PointNotFoundException()
    }
}