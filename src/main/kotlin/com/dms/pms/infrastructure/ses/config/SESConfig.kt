package com.dms.pms.infrastructure.ses

import com.amazonaws.auth.AWSStaticCredentialsProvider
import com.amazonaws.auth.BasicAWSCredentials
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService
import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceClientBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SESConfig (
    private val property: SESProperty
) {

    companion object {
        private const val REGION = "ap-northeast-2"
    }

    @Bean
    fun amazonSimpleEmailService(): AmazonSimpleEmailService {
        val basicAWSCredentials = BasicAWSCredentials(property.accessKey, property.secretKey)
        val credentialsProvider = AWSStaticCredentialsProvider(basicAWSCredentials)

        return AmazonSimpleEmailServiceClientBuilder.standard()
            .withCredentials(credentialsProvider)
            .withRegion(REGION)
            .build()
    }
}