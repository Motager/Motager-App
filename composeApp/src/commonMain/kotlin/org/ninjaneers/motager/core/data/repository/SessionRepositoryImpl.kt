package org.ninjaneers.motager.core.data.repository

import org.ninjaneers.motager.core.data.local.SessionHandler
import org.ninjaneers.motager.core.domain.SessionRepository

class SessionRepositoryImpl(
    private val sessionHandler: SessionHandler
) : SessionRepository {
    override suspend fun getAccessToken(): String? {
        return sessionHandler.getAccessToken()
    }

    override suspend fun updateAccessToken(token: String) {
        sessionHandler.updateAccessToken(token)
    }

    override suspend fun getRefreshToken(): String? {
        return sessionHandler.getRefreshToken()
    }

    override suspend fun updateRefreshToken(token: String) {
        sessionHandler.updateRefreshToken(token)
    }

    override suspend fun updateUserId(id: Int) {
        sessionHandler.updateUserId(id)
    }

    override suspend fun getUserId(): Int? {
        return sessionHandler.getUserId()
    }

    override suspend fun updateAppState(isFirst: Boolean) {
        sessionHandler.updateAppState(isFirst)
    }

    override suspend fun getAppState(): Boolean? {
        return sessionHandler.getAppState()
    }

//    override suspend fun getUserByID(id: Int): Result<User, RemoteError> {
//        return userService.getUserById(id).map { DTO ->
//            DTO.toUser()
//        }
//    }
}