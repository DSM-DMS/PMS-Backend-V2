package com.dms.pms.domain.notification.application

import com.dms.pms.domain.notification.delivery.dto.NotificationDto
import com.dms.pms.domain.student.`interface`.StudentFacade
import com.google.firebase.FirebaseApp
import com.google.firebase.messaging.FirebaseMessaging
import org.springframework.stereotype.Service

@Service
class NotificationService (
    private val firebaseApp: FirebaseApp,
    private val studentFacade: StudentFacade
) {

    companion object {
        private const val TOPIC_PREFIX = "OUTING-"
    }

    fun subscribe(token: NotificationDto.Request, email: String) {

        val students = studentFacade.findAllStudentsByEmail(email)

        for (student in students) {
            FirebaseMessaging.getInstance(firebaseApp)
                .subscribeToTopicAsync(listOf(token.token), TOPIC_PREFIX + student.studentCode.toString())
        }
    }

    fun unsubscribe(token: NotificationDto.Request, email: String) {

        val students = studentFacade.findAllStudentsByEmail(email)

        for (student in students) {
            FirebaseMessaging.getInstance(firebaseApp)
                .unsubscribeFromTopicAsync(listOf(), TOPIC_PREFIX + student.studentCode.toString())
        }
    }
}