package com.dms.pms.domain.notification.domain

import com.dms.pms.domain.student.domain.pms.Student
import javax.persistence.*

@Entity
@Table(name = "device_token")
class DeviceToken (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_code")
    var student: Student? = null,

    @Column(name = "token")
    var token: String
)