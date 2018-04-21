package com.squareup.app.security.auth.jwt.extractor

import org.springframework.security.authentication.AuthenticationServiceException
import org.springframework.stereotype.Component

@Component
class JwtHeaderTokenExtractor : TokenExtractor {

    override fun extract(payload: String): String {

        if (payload.isBlank()) {
            throw AuthenticationServiceException("Authorization header cannot be blank!")
        }

        if (payload.length < HEADER_PREFIX.length) {
            throw AuthenticationServiceException("Invalid authorization header size.")
        }

        return payload.substring(HEADER_PREFIX.length, payload.length)
    }

    companion object {
        private val HEADER_PREFIX = "Bearer "
    }
}
