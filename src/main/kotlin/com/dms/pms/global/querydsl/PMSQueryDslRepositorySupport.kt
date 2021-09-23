package com.dms.pms.global.querydsl

import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext

abstract class PMSQueryDslRepositorySupport(domainClass: Class<*>) : QuerydslRepositorySupport(domainClass) {

    @PersistenceContext(unitName = "pmsEntityManager")
    override fun setEntityManager(entityManager: EntityManager) {
        super.setEntityManager(entityManager)
    }
}