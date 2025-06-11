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
}