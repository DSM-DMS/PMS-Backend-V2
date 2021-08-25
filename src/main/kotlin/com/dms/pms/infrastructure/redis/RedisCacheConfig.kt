package com.dms.pms.infrastructure.redis

import org.springframework.cache.CacheManager
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.redis.cache.RedisCacheConfiguration
import org.springframework.data.redis.cache.RedisCacheManager.RedisCacheManagerBuilder
import org.springframework.data.redis.connection.RedisConnectionFactory
import java.time.Duration

@Configuration
class RedisCacheConfig (
    private val connectionFactory: RedisConnectionFactory
) {
    @Bean
    fun cacheManager(): CacheManager {
        val redisConfig = RedisCacheConfiguration.defaultCacheConfig()
            .entryTtl(Duration.ofSeconds(30))

        return RedisCacheManagerBuilder.fromConnectionFactory(connectionFactory)
            .cacheDefaults(redisConfig).build()
    }
}