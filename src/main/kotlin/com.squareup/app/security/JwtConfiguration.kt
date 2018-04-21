package com.squareup.app.security

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration

@Configuration
@ConfigurationProperties(prefix = "squareup.security.jwt")
class JwtConfiguration {
    lateinit var tokenSigningKey: String
    var tokenExpirationTime: Int = -1 //primitives can't be set as lateinit, default to different value
    var refreshTokenExpTime: Int = -1 //todo: Add validation in a getter?
    lateinit var tokenIssuer: String
    lateinit var corsAllowedOrigin: String
}