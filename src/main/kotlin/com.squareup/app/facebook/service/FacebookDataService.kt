package com.squareup.app.facebook.service

import com.squareup.app.facebook.model.FacebookUserField

interface FacebookDataService {
    fun getUserProfile(accessToken: String, facebookUserId: String, vararg fields: FacebookUserField)
}