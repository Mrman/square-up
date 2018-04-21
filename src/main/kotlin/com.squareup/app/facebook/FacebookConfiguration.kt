package com.squareup.app.facebook

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration

@Configuration
@ConfigurationProperties(prefix = "squareup.facebook")
class FacebookConfiguration {
    lateinit var appId: String
    lateinit var appSecret: String
    lateinit var facebookApiUrl: String
    lateinit var facebookApiVersion: String
}