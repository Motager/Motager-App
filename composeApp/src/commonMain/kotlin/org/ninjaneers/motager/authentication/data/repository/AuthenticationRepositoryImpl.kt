package org.ninjaneers.motager.authentication.data.repository

import org.ninjaneers.motager.authentication.data.mappers.toUser
import org.ninjaneers.motager.authentication.data.remote.AuthenticationService
import org.ninjaneers.motager.authentication.domain.AuthenticationUseCase
import org.ninjaneers.motager.authentication.domain.User
import org.ninjaneers.motager.core.domain.RemoteError
import org.ninjaneers.motager.core.domain.Result
import org.ninjaneers.motager.core.domain.map

class AuthenticationRepositoryImpl(
    private val authenticationService: AuthenticationService
) : AuthenticationUseCase {

    override suspend fun register(
        firstName: String,
        secondName: String,
        email: String,
        password: String
    ): Result<User, RemoteError> {
        return authenticationService
            .register(firstName, secondName, email, password)
            .map { dto ->
                dto.toUser()
            }
    }

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