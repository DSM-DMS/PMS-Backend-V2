package com.dms.pms.domain.student.domain

import javax.persistence.*

@Entity
@Table(name = "student")
class Student (
    @Id @Column(name = "student_code")
    var studentCode: Long,

    @Column(name = "name", nullable = false, unique = true)
    var name: String,

    @Column(name = "number", nullable = false, unique = true)
    var studentNumber: Long,

    @Column(name = "student_id", nullable = false, unique = true)
    val studentId: String,

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    var users: MutableSet<StudentUser> = mutableSetOf()
) {

    fun addUser(user: StudentUser) {
        users.add(user)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Student

        if (studentCode != other.studentCode) return false

        return true
    }

    override fun hashCode(): Int {
        return studentCode.hashCode()
    }
}