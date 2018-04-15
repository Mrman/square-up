package com.squareup.dao

import org.springframework.data.annotation.Id

data class User(
        @Id val id: String,
        val firstName: String,
        val lastName: String
)