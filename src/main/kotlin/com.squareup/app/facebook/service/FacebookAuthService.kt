package com.squareup.app.facebook.service

import com.squareup.app.dao.User
import com.squareup.app.facebook.model.FacebookUserField
import com.squareup.app.model.AccountType
import com.squareup.app.repository.UserRepository
import com.squareup.app.security.auth.jwt.extractor.TokenExtractor
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class FacebookAuthService @Autowired constructor(
        private val tokenExtractor: TokenExtractor,
        private val tokenVerificationService: TokenVerificationService,
        private val facebookDataService: FacebookDataService,
        private val userRepository: UserRepository

) {
    private val logger = LoggerFactory.getLogger(FacebookAuthService::class.java)

    fun processFacebookToken(token: String): User {
        val fbUserAccessToken = tokenExtractor.extract(token)
        val fbAssociatedAccount = tokenVerificationService.verify(fbUserAccessToken)
        //todo: Check the access token for the correct permissions to login

        val facebookUser = facebookDataService.getUserProfile(fbAssociatedAccount.token, fbAssociatedAccount.identifier,
                FacebookUserField.EMAIL, FacebookUserField.FIRST_NAME, FacebookUserField.LAST_NAME
        )

        if (facebookUser.emailAddress == null)
            throw SquareUpLoginException("Reached the end of the login and failing")
            //todo: Handle cases where Facebook does not give us an email address - user may have signed up using a phone number
        else {
            val user = userRepository.findByEmailAddress(facebookUser.emailAddress)
            return if (user != null) {
                val nonFbAssociatedAccounts = user.associatedAccounts.filter { it.type != AccountType.FACEBOOK }.toMutableList()
                val mutableAssociatedAccounts = nonFbAssociatedAccounts.toMutableList()
                mutableAssociatedAccounts.add(fbAssociatedAccount)
                userRepository.save(user.copy(associatedAccounts = mutableAssociatedAccounts))
            } else {
                userRepository.save(User(facebookUser.emailAddress, facebookUser.firstName, facebookUser.lastName, listOf(fbAssociatedAccount)))
            }
        }
    }
}