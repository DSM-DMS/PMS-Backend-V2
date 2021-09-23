package com.dms.pms.domain.point.`interface`

import com.dms.pms.domain.point.`interface`.dto.PointDto

interface PointFacade {
    fun getPointByStudentId(studentId: String): PointDto
}