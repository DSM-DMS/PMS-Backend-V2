package com.dms.pms.domain.point.domain

import com.dms.pms.domain.student.domain.dms.Student
import javax.persistence.*

@Entity
@Table(name = "point_status")
class Point (
    @Id @Column(name = "student_id")
    val studentId: String,

    @OneToOne
    @JoinColumn(name = "student_id")
    val student: Student,

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