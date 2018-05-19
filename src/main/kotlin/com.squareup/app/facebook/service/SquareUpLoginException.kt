package com.squareup.app.facebook.service

import org.springframework.security.core.AuthenticationException

class SquareUpLoginException(s: String) : AuthenticationException(s)
