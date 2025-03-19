package org.ninjaneers.motager.authentication.domain

import org.ninjaneers.motager.authentication.data.dto.RegisterResponseDTO
import org.ninjaneers.motager.core.domain.RemoteError
import org.ninjaneers.motager.core.domain.Result

interface AuthenticationRepository {
    suspend fun register(
        firstName: String,
        secondName: String,
        email: String,
        password: String
    ): Result<User, RemoteError>

    suspend fun login(
        email: String,
        password: String
    ): Result<User, RemoteError>

    suspend fun getUserById(
        userId: Int
    ): Result<RegisterResponseDTO, RemoteError>
}