package org.ninjaneers.motager.login.data.remote

import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.URLProtocol
import io.ktor.http.path
import org.ninjaneers.motager.core.data.network.AVATAR_HOST
import org.ninjaneers.motager.core.data.network.MOTAGER_SERVICES_HOST
import org.ninjaneers.motager.core.data.network.safeCall
import org.ninjaneers.motager.core.domain.RemoteError
import org.ninjaneers.motager.core.domain.Result
import org.ninjaneers.motager.login.data.dto.LoginResponseDTO
import org.ninjaneers.motager.login.data.dto.LoginUserDTO
import org.ninjaneers.motager.login.data.dto.UserDTO

class AuthenticationServiceImpl(
    private val client: HttpClient
) : AuthenticationService {

    override suspend fun login(
        email: String,
        password: String
    ): Result<LoginResponseDTO, RemoteError> {
        val loginUser = LoginUserDTO(
            email = email,
            password = password
        )
        return safeCall {
            client.post {
                url {
                    protocol = URLProtocol.HTTP
                    host = "10.0.2.2:8080"
                    path("login")
                }
                setBody(loginUser)
            }
        }
    }

    override suspend fun getUserById(id: Int): Result<UserDTO, RemoteError> {
        return safeCall<UserDTO> {
            client.get {
                url {
                    protocol = URLProtocol.HTTP
                    host = MOTAGER_SERVICES_HOST
                    path(id.toString())
                }
            }
        }
    }

    override suspend fun getUserAvatar(name: String): Result<ByteArray, RemoteError> {
        return safeCall<ByteArray> {
            client.get {
                url {
                    protocol = URLProtocol.HTTPS
                    host = AVATAR_HOST
                    path("username")
                    parameters.append("username", name)
                }
            }
        }

    }

}