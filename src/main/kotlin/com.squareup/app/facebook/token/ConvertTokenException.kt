package com.squareup.app.facebook.token

import org.springframework.security.core.AuthenticationException

class ConvertTokenException(s: String) : AuthenticationException(s)
