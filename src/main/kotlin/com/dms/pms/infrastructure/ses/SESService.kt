package com.dms.pms.infrastructure.ses

interface SESService {
    fun send(destination: Collection<String>, templateName: String, templateData: Map<String, String>)
}