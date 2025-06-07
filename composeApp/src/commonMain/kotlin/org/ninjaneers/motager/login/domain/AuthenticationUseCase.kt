package org.ninjaneers.motager.login.domain

import org.ninjaneers.motager.core.domain.RemoteError
import org.ninjaneers.motager.core.domain.Result

interface AuthenticationUseCase {

    suspend fun login(
        email: String,
        password: String
    ): Result<User, RemoteError>

    suspend fun getUserById(id: Int): Result<User, RemoteError>

}