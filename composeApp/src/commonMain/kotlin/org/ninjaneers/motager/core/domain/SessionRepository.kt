package org.ninjaneers.motager.core.domain

interface SessionRepository {
    fun getAccessToken(): String?
    fun updateAccessToken(token: String)
}