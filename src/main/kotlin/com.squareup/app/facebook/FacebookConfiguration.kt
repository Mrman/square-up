package com.squareup.app.facebook

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration
import org.springframework.web.util.UriComponentsBuilder

@Configuration
@ConfigurationProperties(prefix = "squareup.facebook")
class FacebookConfiguration {
    lateinit var appId: String
    lateinit var appSecret: String
    lateinit var facebookApiUrl: String
    lateinit var facebookApiVersion: String

    fun facebookApiUriBuilder(accessToken: String): UriComponentsBuilder = facebookApiUriBuilder().queryParam("access_token", accessToken)

    fun facebookApiUriBuilder(): UriComponentsBuilder = UriComponentsBuilder.newInstance()
            .scheme("https")
            .host(facebookApiUrl)
            .pathSegment(facebookApiVersion)
}