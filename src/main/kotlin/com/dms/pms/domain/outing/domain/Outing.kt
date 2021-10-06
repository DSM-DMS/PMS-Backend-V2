package com.dms.pms.domain.outing.domain

import com.dms.pms.domain.outing.domain.types.OutingType
import org.springframework.format.annotation.DateTimeFormat
import java.time.LocalDate
import javax.persistence.*

@Entity
@Table(name = "outing")
class Outing (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(name = "student_number")
    var number: Long,

    @Column(name = "date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    var date: LocalDate,

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    var type: OutingType,

    @Column(name = "reason")
    var reason: String,

    @Column(name = "place")
    var place: String
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Outing

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id?.hashCode() ?: 0
    }
}