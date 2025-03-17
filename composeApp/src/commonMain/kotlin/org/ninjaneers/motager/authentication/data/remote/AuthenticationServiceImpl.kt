package org.ninjaneers.motager.authentication.data.remote

import io.ktor.client.HttpClient
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import org.ninjaneers.motager.authentication.data.dto.RegisterUserDTO
import org.ninjaneers.motager.authentication.data.dto.UserRegisterResponseDTO
import org.ninjaneers.motager.core.data.network.safeCall
import org.ninjaneers.motager.core.domain.RemoteError
import org.ninjaneers.motager.core.domain.Result

class AuthenticationServiceImpl(
    private val client: HttpClient
) : AuthenticationService {
    override suspend fun register(
        firstName: String,
        secondName: String,
        email: String,
        password: String
    ): Result<UserRegisterResponseDTO, RemoteError> {
        val userDTO = RegisterUserDTO(
            firstName = firstName,
            lastName = secondName,
            email = email,
            password = password
        )
        return safeCall<UserRegisterResponseDTO> {
            client.post("http://10.0.2.2:8080/register") {
                setBody(userDTO)
            }
        }
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