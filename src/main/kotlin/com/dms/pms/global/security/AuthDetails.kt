package com.dms.pms.global.security

import com.dms.pms.domain.user.domain.User
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

class AuthDetails (
    private val user: User
) : UserDetails {

    private val authorities: MutableList<SimpleGrantedAuthority> = mutableListOf()

    init {
        this.authorities += SimpleGrantedAuthority(user.roleType.toString())
    }

    override fun getAuthorities(): List<GrantedAuthority> = this.authorities

    override fun getPassword() = user.password

    override fun getUsername() = user.email

    override fun isAccountNonExpired() = true

    override fun isAccountNonLocked() = true

    override fun isCredentialsNonExpired() = true

    override fun isEnabled() = true
}