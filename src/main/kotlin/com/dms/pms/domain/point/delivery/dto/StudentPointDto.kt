package com.dms.pms.domain.point.delivery.dto

import com.dms.pms.domain.point.domain.dto.PointHistoryItem
import com.fasterxml.jackson.annotation.JsonProperty
import java.io.Serializable

class StudentPointDto {
    class Response (
        @JsonProperty("points")
        val points: List<PointHistoryItem>
    ) : Serializable
}