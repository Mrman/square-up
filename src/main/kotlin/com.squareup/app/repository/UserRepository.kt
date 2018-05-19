package com.squareup.app.repository

import com.squareup.app.dao.User
import org.springframework.data.mongodb.repository.MongoRepository

interface UserRepository : MongoRepository<User, String> {
    fun findByEmailAddress(email: String) : User?
    fun findByFirstName(firstName: String) : User?
}