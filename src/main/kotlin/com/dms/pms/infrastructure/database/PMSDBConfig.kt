package com.dms.pms.infrastructure.database

import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.jdbc.DataSourceBuilder
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.orm.jpa.JpaTransactionManager
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean
import org.springframework.transaction.PlatformTransactionManager
import org.springframework.transaction.annotation.EnableTransactionManagement
import javax.persistence.EntityManagerFactory
import javax.sql.DataSource

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
    entityManagerFactoryRef = "pmsEntityManagerFactory",
    transactionManagerRef = "pmsTransactionManager",
    basePackages = ["com.dms.pms.domain.outing", "com.dms.pms.domain.student", "com.dms.pms.domain.user", "com.dms.pms.domain.notification"]
)
class PMSDBConfig {

    @Bean(name = ["pmsDataSource"])
    @Primary
    @ConfigurationProperties("spring.datasource")
    fun dataSource(): DataSource {
        return DataSourceBuilder.create().build()
    }

    @Primary
    @Bean(name = ["pmsEntityManagerFactory"])
    fun localContainerEntityManagerFactoryBean(
        builder: EntityManagerFactoryBuilder,
        @Qualifier("pmsDataSource") dataSource: DataSource
    ): LocalContainerEntityManagerFactoryBean {
        return builder
            .dataSource(dataSource)
            .packages("com.dms.pms.domain.outing", "com.dms.pms.domain.student", "com.dms.pms.domain.user", "com.dms.pms.domain.notification")
            .persistenceUnit("pmsEntityManager")
            .build()
    }

    @Primary
    @Bean(name = ["pmsTransactionManager"])
    fun dmsTransactionManager(
        @Qualifier("pmsEntityManagerFactory") entityManagerFactory: EntityManagerFactory
    ): PlatformTransactionManager {
        return JpaTransactionManager(entityManagerFactory)
    }
}