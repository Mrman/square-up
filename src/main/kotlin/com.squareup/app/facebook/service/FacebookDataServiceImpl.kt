package com.squareup.app.facebook.service

import com.squareup.app.facebook.FacebookConfiguration
import com.squareup.app.facebook.model.User
import com.squareup.app.facebook.model.FacebookUserField
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate

@Service
class FacebookDataServiceImpl @Autowired constructor(
        val facebookConfiguration: FacebookConfiguration
): FacebookDataService {

    private val logger = LoggerFactory.getLogger(FacebookDataServiceImpl::class.java)

    private val template = RestTemplate()

    override fun getUserProfile(accessToken: String, facebookUserId: String, vararg fields: FacebookUserField): User {
        val facebookProfileUri = facebookConfiguration.facebookApiUriBuilder(accessToken)
                .pathSegment(facebookUserId)
                .queryParam("fields", fields.joinToString(",") { it.fieldName })
                .build().toUri()

        logger.info("Requesting from facebook [$facebookProfileUri]")
        val response = template.getForEntity(facebookProfileUri, User::class.java)

        if (response.statusCode.is2xxSuccessful)
            return response.body!!
        else throw FacebookRequestException(response.statusCode)
    }
}