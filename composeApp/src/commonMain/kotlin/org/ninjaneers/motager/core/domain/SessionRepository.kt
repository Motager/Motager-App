package org.ninjaneers.motager.core.domain

interface SessionRepository {
    suspend fun getAccessToken(): String?
    suspend fun updateAccessToken(token: String)
    suspend fun getRefreshToken(): String?
    suspend fun updateRefreshToken(token: String)
    suspend fun updateUserId(id: Int)
    suspend fun getUserId(): Int?
    suspend fun updateAppState(isFirst: Boolean)
    suspend fun getAppState(): Boolean?
//    suspend fun getUserByID(id:Int):Result<User,RemoteError>
}