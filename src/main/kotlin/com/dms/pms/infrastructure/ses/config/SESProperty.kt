package com.dms.pms.infrastructure.ses

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

@ConstructorBinding
@ConfigurationProperties(prefix = "aws.ses")
class SESProperty (
    val accessKey: String,
    val secretKey: String
)