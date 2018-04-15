package com.squareup.dao

import org.springframework.data.annotation.Id
import org.springframework.data.annotation.TypeAlias

@TypeAlias("user")
data class User(
        @Id val id: String,
        val firstName: String,
        val lastName: String
)