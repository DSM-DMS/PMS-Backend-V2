package com.dms.pms.domain.auth.presentation.dto

import org.hibernate.validator.constraints.Length
import javax.validation.constraints.Email
import javax.validation.constraints.NotNull

class LoginDto {
    class Request (
        @Email
        @NotNull
        @Length(max = 30)
        val email: String,

        @NotNull
        @Length(min = 8, max = 14)
        val password: String
    )

    class Response (
        val accessToken: String,
        val refreshToken: String
    )
}