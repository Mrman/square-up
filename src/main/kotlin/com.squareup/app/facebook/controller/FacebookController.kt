package com.squareup.app.facebook.controller

import com.squareup.app.facebook.service.FacebookAuthService
import com.squareup.app.model.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/fb")
class FacebookController @Autowired constructor(
        val facebookAuthService: FacebookAuthService
) {
    @PostMapping(value = ["/login"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun facebookLogin(@RequestHeader("FB-Access-Token") facebookTokenHeader: String): User {
        return facebookAuthService.processFacebookToken(facebookTokenHeader).toDto()
    }

    fun verifyToken(facebookAccessToken: String) {

    }
}