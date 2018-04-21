package com.squareup.app.facebook.token

import com.fasterxml.jackson.annotation.JsonProperty

data class  FacebookAccessTokenData (
        val data: InnerAccessTokenData
)

data class InnerAccessTokenData(
        @JsonProperty("app_id") val app_Id: String,
        val application: String,
        var error: Error?,
        @JsonProperty("expires_at") var expiresAt: Int?,
        @JsonProperty("is_valid") val isValid: Boolean,
        val scopes: List<String> = emptyList(),
        @JsonProperty("user_id") var userId: String?,
        val additionalProperties: Map<String, Any> = emptyMap()
)