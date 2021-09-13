package com.dms.pms.infrastructure.ses

enum class SESTemplateType (
    val templateName: String
) {
    REGISTER_VERIFY("verify-email"),
}