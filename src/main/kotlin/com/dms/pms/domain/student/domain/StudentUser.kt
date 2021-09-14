package com.dms.pms.domain.student.domain

import com.dms.pms.domain.student.domain.types.StudentUserKey
import com.dms.pms.domain.user.domain.User
import javax.persistence.*

@Entity
class StudentUser (
    @EmbeddedId
    var studentUserKey: StudentUserKey,

    @ManyToOne
    @MapsId(value = "email")
    @JoinColumn(name = "email")
    var user: User,

    @ManyToOne
    @MapsId(value = "student_code")
    @JoinColumn(name = "student_code")
    var student: Student
)