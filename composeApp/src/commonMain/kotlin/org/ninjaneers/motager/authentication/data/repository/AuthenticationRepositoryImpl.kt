package org.ninjaneers.motager.authentication.data.repository

import org.ninjaneers.motager.authentication.data.dto.RegisterResponseDTO
import org.ninjaneers.motager.authentication.data.mappers.toUser
import org.ninjaneers.motager.authentication.data.remote.AuthenticationService
import org.ninjaneers.motager.authentication.domain.AuthenticationRepository
import org.ninjaneers.motager.authentication.domain.User
import org.ninjaneers.motager.core.domain.RemoteError
import org.ninjaneers.motager.core.domain.Result
import org.ninjaneers.motager.core.domain.map

class AuthenticationRepositoryImpl(
    private val authenticationService: AuthenticationService
) : AuthenticationRepository {
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

    override suspend fun login(
        email: String,
        password: String
    ): Result<User, RemoteError> {
        TODO("Not yet implemented")
    }

    override suspend fun getUserById(userId: Int): Result<RegisterResponseDTO, RemoteError> {
        TODO("Not yet implemented")
    }

}