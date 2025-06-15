package org.ninjaneers.motager.login.data.remote

import org.ninjaneers.motager.core.domain.RemoteError
import org.ninjaneers.motager.core.domain.Result
import org.ninjaneers.motager.login.data.dto.LoginResponseDTO
import org.ninjaneers.motager.login.data.dto.UserDTO

interface AuthenticationService {

    suspend fun login(
        email: String,
        password: String
    ): Result<LoginResponseDTO, RemoteError>

    suspend fun getUserById(id: Int): Result<UserDTO, RemoteError>
    suspend fun getUserAvatar(name: String): Result<ByteArray, RemoteError>
}