package com.squareup.app.facebook.service

import com.squareup.app.model.AssociatedAccount

interface TokenVerificationService { //move this out if we support other login providers
    fun verify(token: String): AssociatedAccount
}