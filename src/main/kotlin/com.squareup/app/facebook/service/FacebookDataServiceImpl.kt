package com.squareup.app.facebook.service

import com.squareup.app.facebook.FacebookConfiguration
import com.squareup.app.facebook.model.FacebookUser
import com.squareup.app.facebook.model.FacebookUserField
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate

@Service
class FacebookDataServiceImpl @Autowired constructor(
        val facebookConfiguration: FacebookConfiguration
): FacebookDataService {

    private val template = RestTemplate()

    override fun getUserProfile(accessToken: String, facebookUserId: String, vararg fields: FacebookUserField): FacebookUser {
        val facebookProfileUri = facebookConfiguration.facebookApiUriBuilder(accessToken)
                .pathSegment(facebookUserId)
                .queryParam("fields", fields.joinToString(",") { it.fieldName })
                .build().toUri()
        val response = template.getForEntity(facebookProfileUri, FacebookUser::class.java)

        if (response.statusCode.is2xxSuccessful)
            return response.body!!
        else throw FacebookRequestException(response.statusCode)
    }
}