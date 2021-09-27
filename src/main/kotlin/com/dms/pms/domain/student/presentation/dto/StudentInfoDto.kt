package com.dms.pms.domain.student.presentation.dto

class StudentInfoDto {
    class Response (
        val bonusPoint: Int,
        val minusPoint: Int,
        val stay: Long,
        val mealApply: Long
    )
}