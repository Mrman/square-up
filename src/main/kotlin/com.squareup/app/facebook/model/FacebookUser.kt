package com.squareup.app.facebook.model

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonProperty

data class FacebookUser (
        @JsonProperty(FacebookUserField.RawFieldNames.USER_ID) val facebookId: String,
        @JsonProperty(FacebookUserField.RawFieldNames.FIRST_NAME) val firstName: String,
        @JsonProperty(FacebookUserField.RawFieldNames.LAST_NAME) val lastName: String,
        @JsonProperty(FacebookUserField.RawFieldNames.EMAIL_ADDRESS) val emailAddress: String,
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