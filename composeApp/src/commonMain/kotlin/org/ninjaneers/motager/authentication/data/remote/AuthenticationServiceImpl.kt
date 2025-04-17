package org.ninjaneers.motager.authentication.data.remote

import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.URLProtocol
import io.ktor.http.path
import org.ninjaneers.motager.authentication.data.dto.LoginResponseDTO
import org.ninjaneers.motager.authentication.data.dto.LoginUserDTO
import org.ninjaneers.motager.authentication.data.dto.RegisterResponseDTO
import org.ninjaneers.motager.authentication.data.dto.RegisterUserDTO
import org.ninjaneers.motager.authentication.data.dto.UserDTO
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
    ): Result<RegisterResponseDTO, RemoteError> {
        val userDTO = RegisterUserDTO(
            firstName = firstName,
            lastName = secondName,
            email = email,
            password = password
        )
        return safeCall<RegisterResponseDTO> {
            client.post("http://10.0.2.2:8080/register") {
                setBody(userDTO)
            }
        }
    }

    override suspend fun login(
        email: String,
        password: String
    ): Result<LoginResponseDTO, RemoteError> {
        val loginUser = LoginUserDTO(
            email = email,
            password = password
        )
        return safeCall {
            client.post("http://10.0.2.2:8080/login") {
                setBody(loginUser)
            }
        }
    }

    override suspend fun getUserById(userId: Int): Result<UserDTO, RemoteError> {
        return safeCall<UserDTO> {
            client.get {
                url {
                    protocol = URLProtocol.HTTP
                    host = "10.0.2.2:8080"
                    path(userId.toString())
                }
            }
        }
    }

}