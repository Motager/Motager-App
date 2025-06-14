package org.ninjaneers.motager.core.data.local

interface SessionHandler {
    suspend fun getAccessToken(): String?
    suspend fun updateAccessToken(token: String)
    suspend fun getRefreshToken(): String?
    suspend fun updateRefreshToken(token: String)
    suspend fun updateUserId(id: Int)
    suspend fun getUserId(): Int?
    suspend fun updateAppState(isFirst: Boolean)
    suspend fun getAppState(): Boolean?
}