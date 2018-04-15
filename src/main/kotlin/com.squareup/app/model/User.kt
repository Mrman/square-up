package com.squareup.app.model

import com.fasterxml.jackson.annotation.JsonCreator

data class User @JsonCreator constructor(val emailAddress: String, val firstName: String, val lastName: String) {
    fun toDao(): com.squareup.app.dao.User = com.squareup.app.dao.User(emailAddress, firstName, lastName)
}