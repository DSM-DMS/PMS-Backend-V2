package com.dms.pms.domain.outing.presentation.dto

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonProperty
import java.time.LocalDate

class StudentOutingDto {
    class Response (
        @JsonProperty("outings")
        val outings: List<Outing>
    )

    class Outing (
        @JsonProperty("date")
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
        val date: LocalDate,

        @JsonProperty("reason")
        val reason: String,

        @JsonProperty("place")
        val place: String,

        @JsonProperty("type")
        val type: String
    )
}