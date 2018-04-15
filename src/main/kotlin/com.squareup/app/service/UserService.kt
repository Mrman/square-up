package com.squareup.app.service

import com.squareup.app.model.User
import com.squareup.app.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

interface UserService {
    fun userWithFirstName(firstName: String): User?
    fun allUsers(): List<User>
    fun createUser(user: com.squareup.app.model.User): com.squareup.app.model.User
}

@Service("userService")
class UserServiceImpl : UserService {

    @Autowired
    lateinit var userRepository: UserRepository

    override fun userWithFirstName(firstName: String): User? {
        return userRepository.findByFirstName(firstName)?.toDto()
    }

    override fun allUsers(): List<User> {
        return userRepository.findAll().map { it.toDto() }
    }

    override fun createUser(user: com.squareup.app.model.User): com.squareup.app.model.User {
        return userRepository.insert(user.toDao()).toDto()
    }
}