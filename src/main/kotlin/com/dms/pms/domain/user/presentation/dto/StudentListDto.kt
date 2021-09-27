package com.dms.pms.domain.user.presentation.dto

import com.fasterxml.jackson.annotation.JsonProperty

class StudentListDto {
    class Response (
        @JsonProperty("name")
        val name: String,

        @JsonProperty("students")
        val students: List<Student>
    )

    class Student (
        @JsonProperty("student-number")
        private val number: Long,

        @JsonProperty("student-name")
        private val name: String
    )
}