package com.dms.pms.domain.meal.domain.repository

import com.dms.pms.domain.meal.domain.MealApply
import org.springframework.data.jpa.repository.JpaRepository

interface MealApplyRepository : JpaRepository<MealApply, String>