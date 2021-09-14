package com.dms.pms.domain.meal.domain

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "meal_apply")
class MealApply (
    @Id @Column(name = "student_id", length = 20)
    var studentId: String,

    @Column(name = "value", length = 4)
    var value: Long,

    @Column(name = "reason", length = 30)
    var reason: String
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as MealApply

        if (studentId != other.studentId) return false

        return true
    }

    override fun hashCode(): Int {
        return studentId.hashCode()
    }
}