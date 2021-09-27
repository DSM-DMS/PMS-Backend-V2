package com.dms.pms.domain.stay.domain

import com.dms.pms.domain.student.domain.dms.Student
import javax.persistence.*

@Entity
@Table(name = "stay_apply")
class Stay (
    @Id @Column(name = "student_id", length = 20)
    var studentId: String,

    @OneToOne
    @JoinColumn(name = "student_id")
    var student: Student,

    @Column(name = "value", length = 11)
    var value: Long
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Stay

        if (studentId != other.studentId) return false

        return true
    }

    override fun hashCode(): Int {
        return studentId.hashCode()
    }
}