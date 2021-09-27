package com.dms.pms.domain.meal.exception

import com.dms.pms.global.error.BusinessException
import com.dms.pms.global.error.ErrorCode

class MealApplyNotFoundException private constructor() : BusinessException(ErrorCode.MEAL_APPLY_NOT_FOUND) {
    companion object {
        @JvmField
        val EXCEPTION = MealApplyNotFoundException()
    }
}