package org.ninjaneers.motager.core.data.remote

import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.http.URLProtocol
import io.ktor.http.path
import org.ninjaneers.motager.core.data.network.AVATAR_HOST
import org.ninjaneers.motager.core.data.network.MOTAGER_SERVICES_HOST
import org.ninjaneers.motager.core.data.network.safeCall
import org.ninjaneers.motager.core.domain.RemoteError
import org.ninjaneers.motager.core.domain.Result
import org.ninjaneers.motager.login.data.dto.UserDTO

class UserServiceImpl(
    private val client: HttpClient
) : UserService {
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