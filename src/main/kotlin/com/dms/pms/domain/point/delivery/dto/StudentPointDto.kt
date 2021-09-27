package com.dms.pms.domain.point.delivery.dto

import com.fasterxml.jackson.annotation.JsonProperty
import java.time.LocalDate

class StudentPointDto {
    class Response (
        @JsonProperty("points")
        val points: List<Point>
    )

    class Point (
        @JsonProperty("reason")
        val reason: String,

        @JsonProperty("point")
        val point: Int,

        @JsonProperty("date")
        val date: LocalDate,

        @JsonProperty("type")
        val type: Boolean
    )
}