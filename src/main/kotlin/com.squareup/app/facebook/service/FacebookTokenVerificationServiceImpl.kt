package com.squareup.app.facebook.service

import com.squareup.app.facebook.FacebookConfiguration
import com.squareup.app.facebook.token.ConvertTokenException
import com.squareup.app.facebook.token.FacebookAccessTokenData
import com.squareup.app.facebook.token.FacebookLongAccessToken
import com.squareup.app.facebook.token.InvalidTokenException
import com.squareup.app.model.AccountType
import com.squareup.app.model.AssociatedAccount
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.client.RestTemplate

@Service
class FacebookTokenVerificationServiceImpl @Autowired
constructor(
        private val facebookConfiguration: FacebookConfiguration
) : TokenVerificationService {

    private val template = RestTemplate()

    @Transactional
    override fun verify(token: String): AssociatedAccount {
        val fbAccessTokenData = verifyAccessTokenAgainstFacebook(token).data
        val longTermToken = convertToLongTermToken(token)
        return AssociatedAccount(AccountType.FACEBOOK, fbAccessTokenData.userId!!, longTermToken)
    }

    private fun verifyAccessTokenAgainstFacebook(accessToken: String): FacebookAccessTokenData {
        val verifyTokenUri = facebookConfiguration.facebookApiUriBuilder()
                .pathSegment(VERIFY_PATH)
                .queryParam("input_token", accessToken)
                .queryParam("access_token", "${facebookConfiguration.appId}|${facebookConfiguration.appSecret}")
                .build().toUri()

        val response = template.getForEntity(verifyTokenUri, FacebookAccessTokenData::class.java)
        if (response.statusCode.is2xxSuccessful) {
            val body = response.body!!
            if (!body.data.isValid) {
                throw InvalidTokenException("Access token was deemed invalid by Facebook Details[${body.data.error}]")
            } else return body
        } else throw InvalidTokenException(response.statusCode.reasonPhrase)
    }

    private fun convertToLongTermToken(accessToken: String): String {
        val exchangeTokenUri = facebookConfiguration.facebookApiUriBuilder()
                .pathSegment(ACCESS_TOKEN_PATH)
                .queryParam("grant_type", "fb_exchange_token")
                .queryParam("client_id", facebookConfiguration.appId)
                .queryParam("client_secret", facebookConfiguration.appSecret)
                .queryParam("fb_exchange_token", accessToken)
                .build().toUri()

        val response = template.getForEntity(exchangeTokenUri, FacebookLongAccessToken::class.java)
        if (response.statusCode.is2xxSuccessful) {
            return response.body!!.token
        } else {
            LOGGER.error("Error while converting facebook access token to a long access token")
            throw ConvertTokenException("${response.statusCodeValue}: ${response.statusCode.reasonPhrase}")
        }
    }



    companion object {
        private const val VERIFY_PATH = "debug_token"
        private const val ACCESS_TOKEN_PATH = "oauth/access_token"
        private val LOGGER = LoggerFactory.getLogger(FacebookTokenVerificationServiceImpl::class.java)
    }

}
