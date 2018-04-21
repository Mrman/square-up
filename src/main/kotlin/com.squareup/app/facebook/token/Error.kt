package com.squareup.app.facebook.token

import com.fasterxml.jackson.annotation.*

data class Error(
    val code: Int,
    val message: String,
    val subcode: Int,
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
