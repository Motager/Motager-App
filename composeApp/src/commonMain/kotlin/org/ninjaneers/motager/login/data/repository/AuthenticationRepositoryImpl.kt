package org.ninjaneers.motager.login.data.repository

import org.ninjaneers.motager.core.data.local.SessionHandler
import org.ninjaneers.motager.core.domain.RemoteError
import org.ninjaneers.motager.core.domain.Result
import org.ninjaneers.motager.core.domain.map
import org.ninjaneers.motager.core.domain.onSuccess
import org.ninjaneers.motager.login.data.mappers.toUser
import org.ninjaneers.motager.login.data.remote.AuthenticationService
import org.ninjaneers.motager.login.domain.AuthenticationRepository
import org.ninjaneers.motager.login.domain.User

class AuthenticationRepositoryImpl(
    private val service: AuthenticationService,
    private val sessionHandler: SessionHandler
) : AuthenticationRepository {

    override suspend fun login(email: String, password: String): Result<User, RemoteError> {
        var avatar = ByteArray(0)
        return service.login(
            email = email,
            password = password
        ).map { DTO ->
            service.getUserAvatar(DTO.name!!).onSuccess {
                avatar = it
            }
            sessionHandler.updateAccessToken(DTO.accessToken!!)
            sessionHandler.updateAccessToken(DTO.refreshToken!!)
            DTO.toUser(avatar)
        }
    }

    override suspend fun getUserById(id: Int): Result<User, RemoteError> {
        var avatar = ByteArray(0)
        return service.getUserById(id)
            .map { DTO ->
                service.getUserAvatar(userName = DTO.data!!.firstName + DTO.data.lastName)
                    .onSuccess {
                        avatar = it
                    }
                DTO.toUser(avatar)
            }
    }


}