package com.dms.pms.domain.stay.`interface`

import com.dms.pms.domain.stay.domain.StayRepository
import com.dms.pms.domain.stay.exception.StayNotFoundException
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component

@Component
class StayFacadeImpl (
    private val stayRepository: StayRepository
) : StayFacade {
    override fun getStayValueByStudentId(studentId: String): Long {
        val stay = stayRepository.findByIdOrNull(studentId)
            ?: throw StayNotFoundException.EXCEPTION

        return stay.value
    }
}