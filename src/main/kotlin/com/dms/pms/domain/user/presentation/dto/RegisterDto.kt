package com.dms.pms.domain.user.presentation.dto

import org.hibernate.validator.constraints.Length
import javax.validation.constraints.Email
import javax.validation.constraints.NotNull

class RegisterDto {
    class Request (
        @Email
        @Length(max = 30)
        @NotNull
        val email: String,

        @Length(min = 8, max = 14)
        @NotNull
        val password: String,

        @Length(max = 10)
        @NotNull
        val name: String
    )

    class Response (
        val message: String
    )
}