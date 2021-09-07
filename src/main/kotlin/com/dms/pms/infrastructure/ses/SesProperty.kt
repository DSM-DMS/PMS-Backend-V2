package com.dms.pms.infrastructure.ses

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

@ConstructorBinding
@ConfigurationProperties(prefix = "aws.ses")
class SesProperty (
    val accessKeyId: String,
    val secretKey: String
)