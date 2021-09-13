package com.dms.pms.domain.student.domain.types

import java.io.Serializable
import javax.persistence.Column
import javax.persistence.Embeddable

@Embeddable
class StudentUserKey (
    @Column(name = "email")
    val email: String,

    @Column(name = "student_code")
    val studentCode: Long,
) : Serializable