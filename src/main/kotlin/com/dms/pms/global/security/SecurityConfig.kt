package com.dms.pms.global.security

import com.dms.pms.domain.user.domain.types.RoleType
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
@EnableWebSecurity
class SecurityConfig : WebSecurityConfigurerAdapter(), WebMvcConfigurer {

    override fun configure(http: HttpSecurity) {
        http
            .csrf().disable()
            .cors().and()
            .formLogin().disable()
            .sessionManagement().disable()
            .authorizeRequests()
            .antMatchers("/auth").permitAll()
            .antMatchers(HttpMethod.GET, "/user").hasAuthority(RoleType.USER.toString())
            .antMatchers(HttpMethod.POST, "/user").permitAll()
            .antMatchers(HttpMethod.POST, "/student/**").hasAuthority(RoleType.ADMIN.toString())
            .antMatchers("/user/student").hasAuthority(RoleType.USER.toString())
            .antMatchers("/auth/**").permitAll()
            .antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
    }

    override fun addCorsMappings(registry: CorsRegistry) {
        registry.addMapping("/**")
            .allowedOrigins("*")
            .allowedMethods("*")
    }

    @Bean
    fun passwordEncoder(): PasswordEncoder {
        return BCryptPasswordEncoder()
    }
}