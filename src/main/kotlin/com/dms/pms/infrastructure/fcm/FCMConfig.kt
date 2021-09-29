package com.dms.pms.infrastructure.fcm

import com.google.auth.oauth2.GoogleCredentials
import com.google.common.util.concurrent.ListeningExecutorService
import com.google.common.util.concurrent.MoreExecutors
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.io.ClassPathResource

@Configuration
class FCMConfig {

    @Bean
    fun firebaseApp(): FirebaseApp {
        val googleCredentials = GoogleCredentials
            .fromStream(ClassPathResource("pmservice.json").inputStream)

        val firebaseOptions = FirebaseOptions
            .builder()
            .setCredentials(googleCredentials)
            .build()

        return FirebaseApp.initializeApp(firebaseOptions)
    }

    @Bean
    fun firebaseAppExecutor(): ListeningExecutorService {
        return MoreExecutors.newDirectExecutorService()
    }

}