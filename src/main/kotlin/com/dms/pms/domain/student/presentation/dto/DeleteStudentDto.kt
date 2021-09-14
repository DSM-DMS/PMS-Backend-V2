package com.dms.pms.domain.student.presentation.dto

class DeleteStudentDto {
    class Request (
        val number: Long
    )

    class Response (
        val message: String
    )
}