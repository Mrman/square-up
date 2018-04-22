package com.squareup.app.facebook.token

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonProperty

data class  FacebookAccessTokenData (
        val data: InnerAccessTokenData
)

data class InnerAccessTokenData(
        @JsonProperty("app_id") val app_Id: String,
        @JsonProperty("user_id") var userId: String?,
        @JsonProperty("expires_at") var expiresAt: Int?,
        @JsonProperty("is_valid") val isValid: Boolean,
        val application: String,
        var error: Error?,
        val scopes: List<String> = emptyList(),
        private val additionalProperties: MutableMap<String, Any> = mutableMapOf()
) {
    @JsonAnyGetter
    fun getAdditionalProperties(): MutableMap<String, Any> {
        return this.additionalProperties
    }

    @JsonAnySetter
    fun setAdditionalProperty(name: String, value: Any) {
        this.additionalProperties[name] = value
    }
}