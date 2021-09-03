package com.dms.pms.domain.user.domain

import com.dms.pms.domain.user.domain.types.AuthProvider
import com.dms.pms.domain.user.domain.types.RoleType
import javax.persistence.*

@Entity
@Table(name = "users")
class User (
    @Id
    val email: String,

    @Column
    val password: String,

    @Column(nullable = false)
    val name: String,

    @Column(name = "user_role")
    @Enumerated(EnumType.STRING)
    val roleType: RoleType,

    @Column(name = "provider")
    @Enumerated(EnumType.STRING)
    val provider: AuthProvider
)