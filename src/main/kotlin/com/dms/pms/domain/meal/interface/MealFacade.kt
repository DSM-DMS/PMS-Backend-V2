package com.dms.pms.domain.meal.`interface`

interface MealFacade {
    fun getMealApplyStatus(studentId: String): Long
}