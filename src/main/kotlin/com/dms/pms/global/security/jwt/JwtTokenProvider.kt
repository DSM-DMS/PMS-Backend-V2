package com.dms.pms.global.security.jwt

import com.dms.pms.global.security.exception.ExpiredTokenException
import com.dms.pms.global.security.exception.InvalidTokenException
import com.dms.pms.domain.user.domain.User
import com.dms.pms.global.error.exception.InternalErrorException
import com.dms.pms.global.security.AuthDetailsService
import io.jsonwebtoken.*
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.stereotype.Component
import java.util.*
import javax.servlet.http.HttpServletRequest

@Component
class JwtTokenProvider (
    private val authDetailsService: AuthDetailsService,
    private val jwtProperties: JwtProperties
) {

    companion object {
        private const val HEADER = "Authorization"
        private const val PREFIX = "Bearer"
    }

    fun generateAccessToken(user: User): String {
        return Jwts.builder()
            .setIssuedAt(Date())
            .setSubject(user.email)
            .setExpiration(
                Date(System.currentTimeMillis() + jwtProperties.accessExp * 1000)
            )
            .claim("type", "access_token")
            .claim("role", user.roleType)
            .signWith(SignatureAlgorithm.HS256, jwtProperties.secretKey)
            .compact()
    }

    fun generateRefreshToken(user: User): String {
        return Jwts.builder()
            .setIssuedAt(Date())
            .setSubject(user.email)
            .setExpiration(
                Date(System.currentTimeMillis() + jwtProperties.refreshExp * 1000)
            )
            .claim("type", "refresh_token")
            .signWith(SignatureAlgorithm.HS256, jwtProperties.secretKey)
            .compact()
    }

    fun resolveToken(request: HttpServletRequest): String? {
        val bearer = request.getHeader(HEADER)
        if (bearer != null && bearer.length > 7 && bearer.startsWith(PREFIX)) {
            return bearer.substring(7)
        }

        return null
    }

    fun getAuthentication(token: String?): Authentication? {
        return token?.let { it ->
            val claims = parseTokenBody(it)
            val userDetails = authDetailsService.loadUserByUsername(claims.subject)

            return UsernamePasswordAuthenticationToken(userDetails, "", userDetails.authorities)
        }
    }

    private fun parseTokenBody(token: String): Claims {
        return try {
            Jwts.parser().setSigningKey(jwtProperties.secretKey)
                .parseClaimsJws(token).body
        } catch (e: Exception) {
            when (e) {
                is ExpiredJwtException -> throw ExpiredTokenException.EXCEPTION
                is SignatureException, is MalformedJwtException -> throw InvalidTokenException.EXCEPTION
                else -> throw InternalErrorException.EXCEPTION
            }
        }
    }
}