package com.dms.pms.domain.outing.presentation.dto

import com.dms.pms.domain.outing.domain.types.OutingType

class AddOutingDto {
    class Request (
        val number: Long,
        val reason: String,
        val place: String,
        val type: OutingType
    )
}