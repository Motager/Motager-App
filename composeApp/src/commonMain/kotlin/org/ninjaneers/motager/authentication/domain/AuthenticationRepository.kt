package org.ninjaneers.motager.authentication.domain

import org.ninjaneers.motager.authentication.data.dto.UserRegisterResponseDTO
import org.ninjaneers.motager.core.domain.RemoteError
import org.ninjaneers.motager.core.domain.Result

interface AuthenticationRepository {
    suspend fun register(
        firstName: String,
        secondName: String,
        email: String,
        password: String
    ): Result<UserRegisterResponseDTO, RemoteError>

    suspend fun login(
        email: String,
        password: String
    ): Result<UserRegisterResponseDTO, RemoteError>

    suspend fun getUserById(
        userId: Int
    ): Result<UserRegisterResponseDTO, RemoteError>
}