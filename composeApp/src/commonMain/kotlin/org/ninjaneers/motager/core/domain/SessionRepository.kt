package org.ninjaneers.motager.core.domain

interface SessionRepository {
    suspend fun getAccessToken(): String?
    suspend fun updateAccessToken(token: String)
    suspend fun getRefreshToken(): String?
    suspend fun updateRefreshToken(token: String)
}