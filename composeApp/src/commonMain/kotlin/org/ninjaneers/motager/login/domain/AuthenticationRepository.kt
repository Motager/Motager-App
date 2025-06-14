package org.ninjaneers.motager.login.domain

import org.ninjaneers.motager.core.domain.RemoteError
import org.ninjaneers.motager.core.domain.Result

interface AuthenticationRepository {

    suspend fun login(
        email: String,
        password: String
    ): Result<User, RemoteError>

}