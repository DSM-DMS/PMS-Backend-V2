package com.dms.pms.domain.point.domain

import org.springframework.data.annotation.Id
import javax.persistence.Column

class Point (
    @Id @Column(name = "student_id")
    val studentId: String,

    @Column(length = 11, name = "good_point")
    val goodPoint: Int,

    @Column(length = 11, name = "bad_point")
    val badPoint: Int,

    @Column(length = 11, name = "penalty_level")
    val penaltyLevel: Int,

    @Column(name = "penalty_status")
    val penaltyStatus: Boolean
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Point

        if (studentId != other.studentId) return false

        return true
    }

    override fun hashCode(): Int {
        return studentId.hashCode()
    }
}