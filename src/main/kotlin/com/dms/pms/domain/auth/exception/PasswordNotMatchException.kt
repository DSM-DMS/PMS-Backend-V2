package com.dms.pms.domain.auth.exception

import com.dms.pms.global.error.BusinessException
import com.dms.pms.global.error.ErrorCode

class PasswordNotMatchException : BusinessException(ErrorCode.PASSWORD_NOT_MATCHED)