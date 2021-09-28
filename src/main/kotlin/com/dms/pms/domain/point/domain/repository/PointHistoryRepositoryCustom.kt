package com.dms.pms.domain.point.domain.repository

import com.dms.pms.domain.point.domain.dto.PointHistoryItem

interface PointHistoryRepositoryCustom {
    fun getPointHistoriesWithItem(studentId: String): List<PointHistoryItem>
}