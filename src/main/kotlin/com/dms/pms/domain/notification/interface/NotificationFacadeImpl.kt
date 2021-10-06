package com.dms.pms.domain.notification.`interface`

import com.dms.pms.domain.notification.exception.MessageSendFailedException
import com.dms.pms.domain.student.domain.pms.Student
import com.google.api.core.ApiFutureCallback
import com.google.api.core.ApiFutures
import com.google.common.util.concurrent.ListeningExecutorService
import com.google.firebase.FirebaseApp
import com.google.firebase.messaging.BatchResponse
import com.google.firebase.messaging.FirebaseMessaging
import com.google.firebase.messaging.MulticastMessage
import com.google.firebase.messaging.Notification
import mu.KLogging
import org.springframework.stereotype.Component
import java.time.LocalTime

@Component
class NotificationFacadeImpl (
    private val firebaseApp: FirebaseApp,
    private val firebaseAppExecutor: ListeningExecutorService
) : NotificationFacade {

    companion object: KLogging()

    override fun sendOutingMessageByStudent(student: Student) {
        val tokens = student.deviceTokens.map { it.token }

        if (tokens.isEmpty())
            return

        val time = LocalTime.now()
        val message = MulticastMessage.builder()
            .setNotification(
                Notification.builder()
                    .setTitle("학생 외출 알림")
                    .setBody("${student.name}님이 ${time.hour}시 ${time.minute}분에 외출하였습니다.")
                    .build()
            )
            .addAllTokens(tokens)
            .build()

        val apiFuture = FirebaseMessaging.getInstance(firebaseApp).sendMulticastAsync(message)

        ApiFutures.addCallback(apiFuture, object: ApiFutureCallback<BatchResponse> {
            override fun onSuccess(result: BatchResponse) {
                logger.info("Notification message was successfully sent: ${result.successCount} messages")
            }

            override fun onFailure(t: Throwable) {
                throw MessageSendFailedException.EXCEPTION
            }
        }, firebaseAppExecutor)
    }
}