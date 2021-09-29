package com.dms.pms.domain.notification.delivery

import com.dms.pms.domain.notification.application.NotificationService
import com.dms.pms.domain.notification.delivery.dto.NotificationDto
import com.dms.pms.domain.notification.delivery.dto.UnsubscribeDto
import com.dms.pms.global.security.UserInfo
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/notification")
class NotificationDelivery (
    private val notificationService: NotificationService
) {
    @PostMapping
    fun subscribe(@RequestBody @Valid request: NotificationDto.Request, @UserInfo email: String) {
        notificationService.subscribe(request, email)
    }

    @DeleteMapping
    fun unsubscribe(@RequestBody @Valid request: UnsubscribeDto.Request, @UserInfo email: String) {
        notificationService.unsubscribe(request, email)
    }
}