package com.squareup.app.facebook.service

interface TokenVerificationService { //move this out if we support other login providers
    fun verify(token: String): String
}