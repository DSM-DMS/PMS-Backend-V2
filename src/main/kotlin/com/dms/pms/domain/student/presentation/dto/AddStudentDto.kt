package com.dms.pms.domain.student.presentation.dto

class AddStudentDto {
    class Request (
        val number: Long
    )

    class Response (
        val message: String
    )
}