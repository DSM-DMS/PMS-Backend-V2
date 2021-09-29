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
        val number: Long,

        @JsonProperty("student-name")
        val name: String
    )
}