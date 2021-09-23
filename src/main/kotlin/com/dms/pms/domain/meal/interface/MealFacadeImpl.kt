package com.dms.pms.domain.meal.`interface`

import com.dms.pms.domain.meal.domain.MealApply
import com.dms.pms.domain.meal.domain.repository.MealApplyRepository
import com.dms.pms.domain.meal.exception.MealApplyNotFoundException
import org.springframework.data.repository.findByIdOrNull

class MealFacadeImpl (
    private val mealApplyRepository: MealApplyRepository
) : MealFacade {
    override fun getMealApplyStatus(studentId: String): Long {
        val mealApply = mealApplyRepository.findByIdOrNull(studentId)
            ?: throw MealApplyNotFoundException.EXCEPTION

        return mealApply.value
    }
}