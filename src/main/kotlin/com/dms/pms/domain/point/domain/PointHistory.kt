package com.dms.pms.domain.point.domain

import org.springframework.format.annotation.DateTimeFormat
import java.time.LocalDateTime
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "point_history")
class PointHistory (
    @Id @Column(name = "id", length = 11)
    var id: Long,

    @Column(name = "student_id", length = 20)
    var studentId: String,

    @Column(name = "point_id", length = 11)
    var pointId: Long,

    @Column(name = "point_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    var date: LocalDateTime
)