package com.squareup.app.facebook.service

import org.springframework.stereotype.Service

interface FacebookDataService {
    fun getUserProfile(accessToken: String, vararg fields: String)
}