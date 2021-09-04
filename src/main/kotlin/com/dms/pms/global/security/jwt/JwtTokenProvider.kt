package com.dms.pms.global.security.jwt

import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jwts
import org.springframework.stereotype.Component
import javax.servlet.http.HttpServletRequest

@Component
class JwtTokenProvider (
    private val jwtProperties: JwtProperties
) {

    val HEADER = "Authorization"
    val PREFIX = "Bearer"

    fun resolveToken(request: HttpServletRequest): String? {
        val bearer = request.getHeader(HEADER)
        if (bearer != null && bearer.length > 7 && bearer.startsWith(PREFIX)) {
            return bearer.substring(7)
        }

        return null
    }

    fun validateToken(): Boolean {

    }

    fun parseTokenBody(): Claims {
        try {
            return Jwts.parser().setSigningKey()
        }
    }
}