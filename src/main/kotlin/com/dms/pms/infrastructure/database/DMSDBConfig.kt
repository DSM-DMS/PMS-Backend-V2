package com.dms.pms.infrastructure.database

import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.jdbc.DataSourceBuilder
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
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
    entityManagerFactoryRef = "dmsEntityManagerFactory",
    transactionManagerRef = "dmsTransactionManager",
    basePackages = ["com.dms.pms.domain.student.domain.dms", "com.dms.pms.domain.meal", "com.dms.pms.domain.point", "com.dms.pms.domain.stay"]
)
class DMSDBConfig {

    @Bean(name = ["dmsDataSource"])
    @ConfigurationProperties(prefix = "datasource.dms")
    fun dataSource(): DataSource {
        return DataSourceBuilder.create().build()
    }

    @Bean(name = ["dmsEntityManagerFactory"])
    fun localContainerEntityManagerFactoryBean(
        builder: EntityManagerFactoryBuilder,
        @Qualifier("dmsDataSource") dataSource: DataSource
    ): LocalContainerEntityManagerFactoryBean {
        return builder
            .dataSource(dataSource)
            .packages("com.dms.pms.domain.student.domain.dms", "com.dms.pms.domain.meal", "com.dms.pms.domain.point", "com.dms.pms.domain.stay")
            .persistenceUnit("dmsEntityManager")
            .build()
    }

    @Bean(name = ["dmsTransactionManager"])
    fun dmsTransactionManager(
        @Qualifier("dmsEntityManagerFactory")
        entityManagerFactory: EntityManagerFactory
    ): PlatformTransactionManager {
        return JpaTransactionManager(entityManagerFactory)
    }
}