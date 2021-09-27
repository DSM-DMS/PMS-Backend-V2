package com.dms.pms.domain.student.domain.dms

import com.dms.pms.domain.point.domain.Point
import com.dms.pms.domain.point.domain.PointHistory
import com.dms.pms.domain.stay.domain.Stay
import javax.persistence.*

@Entity
@Table(name = "student")
class Student (
    @Id @Column(name = "id", length = 20)
    var id: String,

    @Column(name = "pw")
    private var password: String,

    @Column(name = "name", nullable = true)
    var name: String,

    @Column(name = "number", nullable = true)
    var number: Int,

    @Column(name = "email", nullable = true)
    var email: String,

    @OneToOne(fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn
    var point: Point,

    @OneToOne(fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn
    var stay: Stay,

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "student")
    var pointHistories: MutableList<PointHistory> = mutableListOf(),
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Student

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }
}