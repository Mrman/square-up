package com.squareup.app.facebook.service

import com.squareup.app.security.auth.jwt.extractor.TokenExtractor
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class FacebookAuthService @Autowired constructor(
        private val tokenExtractor: TokenExtractor,
        private val tokenVerificationService: TokenVerificationService
) {
    private val logger = LoggerFactory.getLogger(FacebookAuthService::class.java)

    fun processFacebookToken(token: String) {
        val extractedToken = tokenExtractor.extract(token)
        tokenVerificationService.verify(extractedToken)
//        val facebookTemplate = FacebookTemplate(extractedToken, null, "1560055450772174")
//        val userProfile = facebookTemplate.fetchObject("me", User::class.java, "id", "email", "first_name", "last_name")
//        logger.info(userProfile.toString())
    }
}