package com.squareup.app.facebook.service

import com.squareup.app.SquareUpException
import org.springframework.http.HttpStatus

class FacebookRequestException(statusCode: HttpStatus?) : SquareUpException()
