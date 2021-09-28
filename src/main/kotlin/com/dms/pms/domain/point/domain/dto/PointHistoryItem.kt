package com.dms.pms.domain.point.domain.dto

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonProperty
import com.querydsl.core.annotations.QueryProjection
import java.io.Serializable
import java.time.LocalDate

class PointHistoryItem @QueryProjection constructor (
    @JsonProperty("reason")
    val reason: String,

    @JsonProperty("point")
    val point: Int,

    @JsonProperty("date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
    val date: LocalDate,

    @JsonProperty("type")
    val type: Boolean
) : Serializable