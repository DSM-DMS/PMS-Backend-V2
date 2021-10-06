package com.dms.pms.domain.outing.domain.repository

import com.dms.pms.domain.outing.domain.Outing
import com.dms.pms.domain.outing.domain.QOuting.outing
import com.dms.pms.global.querydsl.PMSQueryDslRepositorySupport

class OutingRepositoryImpl : PMSQueryDslRepositorySupport(Outing::class.java), OutingRepositoryCustom {
    override fun getOutingsByStudentId(studentNumber: Long): List<Outing> {
        return from(outing)
            .where(outing.number.eq(studentNumber))
            .orderBy(outing.date.desc())
            .fetch()
    }
}