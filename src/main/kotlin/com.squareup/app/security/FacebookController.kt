package com.squareup.app.security

import com.squareup.app.model.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/fb")
class FacebookController @Autowired constructor(
) {
    @PostMapping(value = ["/login"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun facebookLogin(): User {
        return User("testing@test.co.uk", "Joe", "Bloggs")
    }
}