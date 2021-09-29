package com.dms.pms.domain.point.domain.repository

import com.dms.pms.domain.point.domain.PointHistory
import org.springframework.data.jpa.repository.JpaRepository

interface PointHistoryRepository : JpaRepository<PointHistory, Long>, PointHistoryRepositoryCustom