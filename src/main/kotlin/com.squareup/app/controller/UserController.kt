package com.squareup.app.controller

import com.squareup.app.model.User
import com.squareup.app.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController {

    @Autowired
    lateinit var userService: UserService

    @GetMapping("/user")
    fun users() = userService.allUsers()

    @PostMapping("/user")
    fun createUser(@RequestBody user: User) = userService.createUser(user)

//    @GetMapping("/user")
//    fun user(@RequestParam(value = "firstName") name: String ) = userService.userWithFirstName(name)

}