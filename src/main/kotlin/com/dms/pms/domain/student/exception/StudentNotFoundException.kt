package com.dms.pms.domain.student.exception

import com.dms.pms.global.error.BusinessException
import com.dms.pms.global.error.ErrorCode

class StudentNotFoundException {
    companion object {
        @JvmField
        val EXCEPTION = BusinessException(ErrorCode.STUDENT_NOT_FOUND)
    }
}