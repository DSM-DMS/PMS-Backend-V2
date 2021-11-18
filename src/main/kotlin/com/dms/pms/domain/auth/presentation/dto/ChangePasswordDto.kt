package com.dms.pms.domain.auth.presentation.dto

import com.fasterxml.jackson.annotation.JsonProperty

class ChangePasswordDto {
    class Request (
        @JsonProperty("pre_password")
        val prePassword: String,

        @JsonProperty("password")
        val password: String
    )
}