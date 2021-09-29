package com.dms.pms.domain.notification.application

import com.dms.pms.domain.notification.delivery.dto.NotificationDto
import com.dms.pms.domain.notification.delivery.dto.UnsubscribeDto
import com.dms.pms.domain.notification.domain.DeviceToken
import com.dms.pms.domain.notification.domain.repository.DeviceTokenRepository
import com.dms.pms.domain.student.`interface`.StudentFacade
import com.google.firebase.FirebaseApp
import com.google.firebase.messaging.FirebaseMessaging
import org.springframework.stereotype.Service

@Service
class NotificationService(
    private val deviceTokenRepository: DeviceTokenRepository,
    private val studentFacade: StudentFacade
) {

    fun subscribe(request: NotificationDto.Request, email: String) {

        val students = studentFacade.findAllStudentsByEmail(email)

        for (student in students) {
            val token = DeviceToken(token = request.token)
            student.addDeviceToken(token)

            deviceTokenRepository.save(token)
        }
    }

    fun unsubscribe(request: UnsubscribeDto.Request, email: String) {

        val students = studentFacade.findAllStudentsByEmail(email)

        for (student in students)
            deviceTokenRepository.deleteAllByToken(request.token)

    }
}