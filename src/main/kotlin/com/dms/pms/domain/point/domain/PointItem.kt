package com.dms.pms.domain.point.domain

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "point_item")
class PointItem (
    @Id @Column(name = "id", length = 11)
    var id: Long,

    @Column(name = "reason")
    var reason: String,

    @Column(name = "point", length = 11)
    var point: Long,

    @Column(name = "type")
    var type: Boolean
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as PointItem

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }
}