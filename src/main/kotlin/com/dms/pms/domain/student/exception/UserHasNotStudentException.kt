package com.dms.pms.domain.student.exception

import com.dms.pms.global.error.BusinessException
import com.dms.pms.global.error.ErrorCode

class UserHasNotStudentException private constructor() : BusinessException(ErrorCode.USER_HAS_NOT_STUDENT) {
    companion object {
        @JvmField
        val EXCEPTION = UserHasNotStudentException()
    }
}