package com.squareup.app.model

data class User constructor(val emailAddress: String?, val firstName: String, val lastName: String) {
    fun toDao(): com.squareup.app.dao.User = com.squareup.app.dao.User(
            emailAddress = emailAddress,
            firstName = firstName,
            lastName = lastName
    )
}