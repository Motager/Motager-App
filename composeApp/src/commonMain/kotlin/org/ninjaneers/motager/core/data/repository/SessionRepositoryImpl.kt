package org.ninjaneers.motager.core.data.repository

import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.IO
import kotlinx.coroutines.launch
import org.ninjaneers.motager.core.data.local.SessionHandler
import org.ninjaneers.motager.core.domain.SessionRepository

@OptIn(DelicateCoroutinesApi::class)
class SessionRepositoryImpl(
    private val sessionHandler: SessionHandler
) : SessionRepository {
    val coroutineScope = GlobalScope
    override fun getAccessToken(): String? {
        var token: String? = null
        coroutineScope.launch(Dispatchers.IO) {
            token = sessionHandler.getAccessToken()
        }
        return token
    }

    override fun updateAccessToken(token: String) {
        coroutineScope.launch {
            sessionHandler.updateAccessToken(token)
        }
    }

    override fun getRefreshToken(): String? {
        var token: String? = null
        coroutineScope.launch(Dispatchers.IO) {
            token = sessionHandler.getRefreshToken()
        }
        return token
    }

    override fun updateRefreshToken(token: String) {
        coroutineScope.launch {
            sessionHandler.updateRefreshToken(token)
        }
    }
}