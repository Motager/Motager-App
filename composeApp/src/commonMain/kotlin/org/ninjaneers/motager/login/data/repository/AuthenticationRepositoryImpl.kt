package org.ninjaneers.motager.login.data.repository

import org.ninjaneers.motager.core.domain.RemoteError
import org.ninjaneers.motager.core.domain.Result
import org.ninjaneers.motager.core.domain.map
import org.ninjaneers.motager.login.data.mappers.toUser
import org.ninjaneers.motager.login.data.remote.AuthenticationService
import org.ninjaneers.motager.login.domain.AuthenticationUseCase
import org.ninjaneers.motager.login.domain.User

class AuthenticationRepositoryImpl(
    private val authenticationService: AuthenticationService
) : AuthenticationUseCase {

    override suspend fun login(email: String, password: String): Result<User, RemoteError> {
        return authenticationService.login(
            email = email,
            password = password
        ).map { dto ->
            dto.toUser()
        }
    }

    override suspend fun getUserById(id: Int): Result<User, RemoteError> {
        return authenticationService.getUserById(id)
            .map { dto ->
                dto.toUser()
            }
    }

}