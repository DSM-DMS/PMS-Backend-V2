package com.dms.pms.domain.auth.presentation.dto

import com.fasterxml.jackson.annotation.JsonProperty
import javax.validation.constraints.NotNull

class ChangePasswordDto {
    class Request (
        @NotNull
        @JsonProperty("pre_password")
        val prePassword: String,
        @NotNull
        @JsonProperty("password")
        val password: String
    )
}