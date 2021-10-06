package com.dms.pms.domain.notification.delivery.dto

import javax.validation.constraints.NotNull

class UnsubscribeDto {
    class Request (
        @NotNull
        val token: String
    )
}