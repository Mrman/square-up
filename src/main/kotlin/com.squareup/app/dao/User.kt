package com.squareup.app.dao

import org.springframework.data.annotation.Id
import org.springframework.data.annotation.TypeAlias

@TypeAlias("user")
data class User(
        @Id val emailAddress: String,
        val firstName: String,
        val lastName: String
) {
    fun toDto(): com.squareup.app.model.User {
        return com.squareup.app.model.User(emailAddress, firstName, lastName)
    }
}