package com.dms.pms.domain.outing.domain.types

import com.fasterxml.jackson.annotation.JsonCreator

enum class OutingType {
    NORMAL, DISEASE;

    companion object {
        @JvmStatic
        @JsonCreator
        fun from(str: String): OutingType {
            return OutingType.valueOf(str.toUpperCase())
        }
    }
}