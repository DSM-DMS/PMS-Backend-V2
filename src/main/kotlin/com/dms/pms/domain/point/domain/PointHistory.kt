package com.dms.pms.domain.point.domain

import com.dms.pms.domain.student.domain.dms.Student
import org.hibernate.annotations.Cache
import org.hibernate.annotations.CacheConcurrencyStrategy
import org.springframework.format.annotation.DateTimeFormat
import java.time.LocalDate
import javax.persistence.*

@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
@Entity
@Table(name = "point_history")
class PointHistory (
    @Id @Column(name = "id", length = 11)
    var id: Long,

    @ManyToOne
    @JoinColumn(name = "student_id")
    var student: Student,

    @ManyToOne
    @JoinColumn(name = "point_id")
    var pointItem: PointItem,

    @Column(name = "point_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    var date: LocalDate
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as PointHistory

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }
}