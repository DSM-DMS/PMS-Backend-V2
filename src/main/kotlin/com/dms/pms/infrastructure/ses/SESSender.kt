package com.dms.pms.infrastructure.ses

import com.amazonaws.services.simpleemail.AmazonSimpleEmailService
import com.amazonaws.services.simpleemail.model.Destination
import com.amazonaws.services.simpleemail.model.SendTemplatedEmailRequest
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

@Service
class SESSender (
    private val amazonSimpleEmailService: AmazonSimpleEmailService,
    @Value("\${aws.ses.sender}") private val sender: String
) : SESService {
    override fun send(destination: Collection<String>, templateName: String, templateData: Map<String, String>) {
        val request = SendTemplatedEmailRequest()

        val des = Destination()
        des.setToAddresses(destination)

        request.template = templateName
        request.source = sender
        request.destination = des

        val jsonStr = ObjectMapper().writeValueAsString(templateData)

        request.templateData = jsonStr

        amazonSimpleEmailService.sendTemplatedEmail(request)
    }
}