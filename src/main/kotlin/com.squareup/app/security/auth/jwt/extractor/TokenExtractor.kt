package com.squareup.app.security.auth.jwt.extractor

interface TokenExtractor {
    fun extract(payload: String): String
}
