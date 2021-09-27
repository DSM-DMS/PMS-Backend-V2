package com.dms.pms.domain.point.domain.repository

import com.dms.pms.domain.point.domain.PointHistory
import com.dms.pms.global.querydsl.DMSQueryDslRepositorySupport

class PointHistoryRepositoryImpl : DMSQueryDslRepositorySupport(PointHistory::class.java), PointHistoryRepositoryCustom {
    
}