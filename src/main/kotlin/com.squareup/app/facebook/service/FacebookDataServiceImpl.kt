package com.squareup.app.facebook.service

import com.squareup.app.facebook.model.FacebookUserField
import org.springframework.stereotype.Service

@Service
class FacebookDataServiceImpl : FacebookDataService {
    override fun getUserProfile(accessToken: String, facebookUserId: String, vararg fields: FacebookUserField) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}