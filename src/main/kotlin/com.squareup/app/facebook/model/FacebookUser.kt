package com.squareup.app.facebook.model

data class FacebookUser(
        val facebookId: Int,
        val firstName: String,
        val lastName: String,
        val emailAddress: String
)