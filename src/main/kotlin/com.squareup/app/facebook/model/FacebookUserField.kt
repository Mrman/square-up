package com.squareup.app.facebook.model

enum class FacebookUserField(val fieldName: String) {
    USER_ID(RawFieldNames.USER_ID),
    FIRST_NAME(RawFieldNames.FIRST_NAME),
    LAST_NAME(RawFieldNames.LAST_NAME),
    EMAIL(RawFieldNames.EMAIL_ADDRESS);

    object RawFieldNames {
        const val USER_ID = "id"
        const val FIRST_NAME = "first_name"
        const val LAST_NAME = "last_name"
        const val EMAIL_ADDRESS = "email"
    }
}



