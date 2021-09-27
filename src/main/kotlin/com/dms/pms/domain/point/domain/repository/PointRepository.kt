package com.dms.pms.domain.point.domain.repository

import com.dms.pms.domain.point.domain.Point
import org.springframework.data.jpa.repository.JpaRepository

interface PointRepository : JpaRepository<Point, String> {
    fun findByStudentId(studentId: String): Point?
}