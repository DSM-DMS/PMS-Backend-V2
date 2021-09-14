package com.dms.pms.domain.stay.`interface`

interface StayFacade {
    fun getStayValueByStudentId(studentId: String): Long
}