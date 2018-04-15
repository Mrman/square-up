package com.squareup.app.controller

import com.squareup.app.model.User
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.atomic.AtomicLong

@RestController
class UserController {
    val counter = AtomicLong()

    @GetMapping("/user")
    fun user(@RequestParam(value = "name", defaultValue= "Craig") name: String ) = User(counter.incrementAndGet(), name)
}