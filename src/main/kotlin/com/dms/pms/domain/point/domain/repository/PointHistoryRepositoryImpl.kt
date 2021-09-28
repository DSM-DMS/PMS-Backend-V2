package com.dms.pms.domain.point.domain.repository

import com.dms.pms.domain.point.domain.PointHistory
import com.dms.pms.domain.point.domain.QPointHistory.pointHistory
import com.dms.pms.domain.point.domain.QPointItem.pointItem
import com.dms.pms.domain.point.domain.dto.PointHistoryItem
import com.dms.pms.domain.point.domain.dto.QPointHistoryItem
import com.dms.pms.global.querydsl.DMSQueryDslRepositorySupport

class PointHistoryRepositoryImpl : DMSQueryDslRepositorySupport(PointHistory::class.java), PointHistoryRepositoryCustom {
    override fun getPointHistoriesWithItem(studentId: String): List<PointHistoryItem> {
        return from(pointHistory)
            .select(
                QPointHistoryItem(
                    pointItem.reason,
                    pointItem.point,
                    pointHistory.date,
                    pointItem.type
                )
            )
            .innerJoin(pointHistory.pointItem, pointItem)
            .where(pointHistory.student.id.eq(studentId))
            .fetch()
    }
}