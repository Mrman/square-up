package com.squareup.app.dao

import com.squareup.app.model.AssociatedAccount
import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.annotation.TypeAlias

@TypeAlias("user")
data class User(
        val emailAddress: String?, //unique partial index in mongo - allows creation of users without knowing their id, just a facebook id
        val firstName: String,
        val lastName: String,
        val associatedAccounts: List<AssociatedAccount> = emptyList(),
        @Id val id: ObjectId? = null
) {
    fun toDto(): com.squareup.app.model.User {
        return com.squareup.app.model.User(emailAddress, firstName, lastName)
    }
}