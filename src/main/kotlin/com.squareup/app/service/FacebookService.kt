package com.squareup.app.service

import com.squareup.app.security.auth.jwt.extractor.TokenExtractor
import org.springframework.beans.factory.annotation.Autowired

class FacebookService @Autowired constructor(
    val tokenExtractor: TokenExtractor
) {

    fun processFacebookToken(token: String) {
        val extractedToken = tokenExtractor.extract(token)

    }
}