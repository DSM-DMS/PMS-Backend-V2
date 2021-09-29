package com.dms.pms.domain.outing.application

import com.dms.pms.domain.notification.`interface`.NotificationFacade
import com.dms.pms.domain.outing.domain.Outing
import com.dms.pms.domain.outing.domain.repository.OutingRepository
import com.dms.pms.domain.outing.presentation.dto.AddOutingDto
import com.dms.pms.domain.outing.presentation.dto.StudentOutingDto
import com.dms.pms.domain.student.`interface`.StudentFacade
import org.springframework.stereotype.Service
import java.time.LocalDate

@Service
class OutingService (
    private val outingRepository: OutingRepository,
    private val studentFacade: StudentFacade,
    private val notificationFacade: NotificationFacade
) {
    fun getStudentOutings(number: Long, email: String): StudentOutingDto.Response {
        studentFacade.checkIsUserHasStudentAndGetId(email, number)
        val outings = outingRepository.getOutingsByStudentId(number)
            .map {
                StudentOutingDto.Outing(
                    date = it.date,
                    reason = it.reason,
                    place = it.place,
                    type = it.type.toString()
                )
            }

        return StudentOutingDto.Response(outings)
    }

    fun addOuting(request: AddOutingDto.Request) {
        outingRepository.save(
            Outing(
                studentNumber = request.number,
                reason = request.reason,
                place = request.place,
                date = LocalDate.now(),
                type = request.type,
            )
        )

        val student = studentFacade.findStudentByNumber(request.number)
        notificationFacade.sendOutingMessageByStudent(student)
    }
}