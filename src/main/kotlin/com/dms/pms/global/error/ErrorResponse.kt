package com.dms.pms.global.error

class ErrorResponse (
    private val status: Int,
    private val message: String
) {
    companion object {
        fun of(code: ErrorCode): ErrorResponse {
            return ErrorResponse(status = code.status, message = code.message)
        }
    }

    override fun toString(): String {
        return """
            {
                "status": ${this.status},
                "message": "${this.message}"
            }
        """.trimIndent()
    }
}