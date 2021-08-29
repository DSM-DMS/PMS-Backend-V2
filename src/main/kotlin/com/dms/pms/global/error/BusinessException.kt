package com.dms.pms.global.error

open class BusinessException(val code: ErrorCode) : RuntimeException()