package com.dms.pms.domain.auth.presentation.dto

import javax.validation.constraints.Email
import javax.validation.constraints.NotNull

class ResetPasswordDto {
    class Request (
        @Email(message = "Email address is not valid.")
        @NotNull
        val email: String
    )
}