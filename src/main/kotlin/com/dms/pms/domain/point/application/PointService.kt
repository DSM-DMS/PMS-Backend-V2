package com.dms.pms.domain.point.application

import com.dms.pms.domain.point.delivery.dto.StudentPointDto
import com.dms.pms.domain.point.domain.repository.PointHistoryRepository
import com.dms.pms.domain.student.`interface`.StudentFacade
import org.springframework.stereotype.Service

@Service
class PointService (
    private val pointHistoryRepository: PointHistoryRepository,
    private val studentFacade: StudentFacade
) {
    fun getStudentPointHistory(number: Long, email: String): StudentPointDto.Response {

        val studentId = studentFacade.checkIsUserHasStudentAndGetId(email, number)
        val pointHistories = pointHistoryRepository.getPointHistoriesWithItem(studentId)

        return StudentPointDto.Response(pointHistories)
    }
}