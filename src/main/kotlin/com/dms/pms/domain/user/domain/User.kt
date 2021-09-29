package com.dms.pms.domain.user.domain

import com.dms.pms.domain.student.domain.pms.StudentUser
import com.dms.pms.domain.user.domain.types.AuthProvider
import com.dms.pms.domain.user.domain.types.RoleType
import javax.persistence.*

@Entity
@Table(name = "users")
class User (
    @Id
    var email: String,

    @Column
    var password: String,

    @Column(nullable = false)
    var name: String,

    @Column(name = "user_role")
    @Enumerated(EnumType.STRING)
    var roleType: RoleType,

    @Column(name = "provider")
    @Enumerated(EnumType.STRING)
    var provider: AuthProvider,

    @OneToMany(mappedBy = "student", fetch = FetchType.LAZY)
    var students: MutableList<StudentUser> = mutableListOf(),

) {

    fun addStudent(student: StudentUser) {
        students.add(student)
    }

    fun changePassword(password: String) {
        this.password = password
    }

    fun changeName(name: String) {
        this.name = name
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as User

        if (email != other.email) return false

        return true
    }

    override fun hashCode(): Int {
        return email.hashCode()
    }
}