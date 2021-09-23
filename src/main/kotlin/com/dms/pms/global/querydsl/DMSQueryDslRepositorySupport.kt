package com.dms.pms.global.querydsl

import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport
import org.springframework.stereotype.Repository
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext

@Repository
abstract class DMSQueryDslRepositorySupport(domainClass: Class<*>) : QuerydslRepositorySupport(domainClass) {

    @PersistenceContext(name = "dmsEntityManager")
    override fun setEntityManager(entityManager: EntityManager) {
        super.setEntityManager(entityManager)
    }
}