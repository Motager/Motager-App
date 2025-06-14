package org.ninjaneers.motager.login.data.repository

import org.ninjaneers.motager.core.data.local.SessionHandler
import org.ninjaneers.motager.core.domain.RemoteError
import org.ninjaneers.motager.core.domain.Result
import org.ninjaneers.motager.core.domain.map
import org.ninjaneers.motager.login.data.mappers.toUser
import org.ninjaneers.motager.login.data.remote.AuthenticationService
import org.ninjaneers.motager.login.domain.AuthenticationRepository
import org.ninjaneers.motager.login.domain.User

class AuthenticationRepositoryImpl(
    private val service: AuthenticationService,
    private val sessionHandler: SessionHandler
) : AuthenticationRepository {

    override suspend fun login(email: String, password: String): Result<User, RemoteError> {
        return service.login(
            email = email,
            password = password
        ).map { DTO ->
            sessionHandler.updateAccessToken(DTO.accessToken!!)
            sessionHandler.updateRefreshToken(DTO.refreshToken!!)
            DTO.toUser()
        }
    }

    override suspend fun getUserById(id: Int): Result<User, RemoteError> {
        return service.getUserById(id)
            .map { DTO ->
                DTO.toUser()
            }
    }

    override suspend fun getUserAvatar(name: String): Result<ByteArray, RemoteError> {
        return service.getUserAvatar(name)
    }


}