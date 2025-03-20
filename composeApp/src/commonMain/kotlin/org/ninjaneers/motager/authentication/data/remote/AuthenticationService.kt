package org.ninjaneers.motager.authentication.data.remote

import org.ninjaneers.motager.authentication.data.dto.LoginResponseDTO
import org.ninjaneers.motager.authentication.data.dto.RegisterResponseDTO
import org.ninjaneers.motager.core.domain.RemoteError
import org.ninjaneers.motager.core.domain.Result

interface AuthenticationService {
    suspend fun register(
        firstName: String,
        secondName: String,
        email: String,
        password: String
    ): Result<RegisterResponseDTO, RemoteError>

    suspend fun login(
        email: String,
        password: String
    ): Result<LoginResponseDTO, RemoteError>

    suspend fun getUserById(
        userId: Int
    ): Result<RegisterResponseDTO, RemoteError>
}