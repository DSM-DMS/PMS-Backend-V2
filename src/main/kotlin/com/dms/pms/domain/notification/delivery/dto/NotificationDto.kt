package com.dms.pms.domain.notification.delivery.dto

import javax.validation.constraints.NotNull

class NotificationDto {
    class Request (
        @NotNull
        val token: String
    )
}