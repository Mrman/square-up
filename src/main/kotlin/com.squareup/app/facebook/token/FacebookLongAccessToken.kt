package com.squareup.app.facebook.token

import com.fasterxml.jackson.annotation.JsonProperty

data class FacebookLongAccessToken(
        @JsonProperty("access_token") val token: String
)