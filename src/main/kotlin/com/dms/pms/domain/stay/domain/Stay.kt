package com.dms.pms.domain.stay.domain

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "stay_apply")
class Stay (
    @Id @Column(name = "student_id", length = 20)
    var studentId: String,

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