package com.dms.pms.domain.point.`interface`

import com.dms.pms.domain.point.`interface`.dto.PointDto
import com.dms.pms.domain.point.domain.repository.PointRepository
import com.dms.pms.domain.point.exception.PointNotFoundException
import org.springframework.stereotype.Component

@Component
class PointFacadeImpl (
    private val pointRepository: PointRepository
) : PointFacade {
    override fun getPointByStudentId(studentId: String): PointDto {
        val point = pointRepository.findByStudentId(studentId)
            ?: throw PointNotFoundException.EXCEPTION

        return PointDto(
            bonusPoint = point.goodPoint,
            minusPoint = point.badPoint
        )
    }
}