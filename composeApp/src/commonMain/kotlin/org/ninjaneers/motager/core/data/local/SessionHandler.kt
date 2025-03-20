package org.ninjaneers.motager.core.data.local

interface SessionHandler {
    suspend fun getAccessToken(): String?
    suspend fun updateAccessToken(token: String)
}