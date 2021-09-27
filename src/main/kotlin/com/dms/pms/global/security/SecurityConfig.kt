package com.dms.pms.global.security

import com.dms.pms.domain.user.domain.types.RoleType
import com.dms.pms.global.error.HandleExceptionFilter
import com.dms.pms.global.security.filter.JwtTokenFilter
import com.dms.pms.global.security.filter.SecurityFilterConfigure
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder

@Configuration
@EnableWebSecurity
class SecurityConfig (
    private val jwtTokenFilter: JwtTokenFilter,
    private val handleExceptionFilter: HandleExceptionFilter
) : WebSecurityConfigurerAdapter() {

    override fun configure(http: HttpSecurity) {
        http
            .csrf().disable()
            .cors().and()
            .formLogin().disable()
            .sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()

            .authorizeRequests()
            .antMatchers("/auth").permitAll()
            .antMatchers(HttpMethod.GET, "/user").hasAuthority(RoleType.USER.toString())
            .antMatchers(HttpMethod.POST, "/user").permitAll()
            .antMatchers(HttpMethod.GET, "/user/verify").permitAll()
            .antMatchers(HttpMethod.POST, "/student/**").hasAuthority(RoleType.ADMIN.toString())
            .antMatchers("/user/student").hasAuthority(RoleType.USER.toString())
            .antMatchers("/user/student/**").hasAuthority(RoleType.USER.toString())
            .antMatchers("/auth/**").permitAll()
            .antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
            .anyRequest().denyAll()
            .and().apply(SecurityFilterConfigure(jwtTokenFilter, handleExceptionFilter))
    }

    @Bean
    fun passwordEncoder(): PasswordEncoder {
        return BCryptPasswordEncoder()
    }
}