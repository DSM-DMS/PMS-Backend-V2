package com.dms.pms.domain.student.presentation.dto

import javax.validation.constraints.NotNull

class DeleteStudentDto {
    class Request (
        @NotNull
        val number: Long
    )

    class Response (
        val message: String
    )
}