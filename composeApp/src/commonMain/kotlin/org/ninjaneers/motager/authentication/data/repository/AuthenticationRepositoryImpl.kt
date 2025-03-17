package org.ninjaneers.motager.authentication.data.repository

import org.ninjaneers.motager.authentication.data.dto.UserRegisterResponseDTO
import org.ninjaneers.motager.authentication.data.remote.AuthenticationService
import org.ninjaneers.motager.authentication.domain.AuthenticationRepository
import org.ninjaneers.motager.core.domain.RemoteError
import org.ninjaneers.motager.core.domain.Result

class AuthenticationRepositoryImpl(
    private val authenticationService: AuthenticationService
) : AuthenticationRepository {
    override suspend fun register(
        firstName: String,
        secondName: String,
        email: String,
        password: String
    ): Result<UserRegisterResponseDTO, RemoteError> {
        return authenticationService.register(firstName, secondName, email, password)
    }

    override suspend fun login(
        email: String,
        password: String
    ): Result<UserRegisterResponseDTO, RemoteError> {
        TODO("Not yet implemented")
    }

    override suspend fun getUserById(userId: Int): Result<UserRegisterResponseDTO, RemoteError> {
        TODO("Not yet implemented")
    }

}