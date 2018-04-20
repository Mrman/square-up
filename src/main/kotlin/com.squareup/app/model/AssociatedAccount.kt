package com.squareup.app.model

data class AssociatedAccount(val type: AccountType, val identifier: String)

enum class AccountType {
    FACEBOOK
}
