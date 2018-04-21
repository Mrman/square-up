package com.squareup.app.facebook.token

import org.springframework.security.core.AuthenticationException

class InvalidTokenException : AuthenticationException {
    constructor(message: String, t: Throwable) : super(message, t)
    constructor(s: String) : super(s)
}
