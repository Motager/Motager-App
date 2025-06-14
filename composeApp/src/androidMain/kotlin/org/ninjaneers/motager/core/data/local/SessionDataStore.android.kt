package org.ninjaneers.motager.core.data.local

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import okio.Path.Companion.toPath

@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
actual class SessionDataStore(context: Context) : SessionHandler {

    private val sessionDataStore: DataStore<Preferences> =
        PreferenceDataStoreFactory.createWithPath(
            produceFile = { context.filesDir.resolve(SESSION_FILE_NAME).absolutePath.toPath() }
        )

    override suspend fun getAccessToken(): String? {
        return sessionDataStore.data.map { data ->
            data[ACCESS_TOKEN_KEY]
        }.first()
    }

    override suspend fun updateAccessToken(token: String) {
        sessionDataStore.edit { data ->
            data[ACCESS_TOKEN_KEY] = token
        }
    }

    override suspend fun getRefreshToken(): String? {
        return sessionDataStore.data.map { data ->
            data[REFRESH_TOKEN_KEY]
        }.first()
    }

    override suspend fun updateRefreshToken(token: String) {
        sessionDataStore.edit { data ->
            data[REFRESH_TOKEN_KEY] = token
        }
    }

    override suspend fun updateUserId(id: Int) {
        sessionDataStore.edit { data ->
            data[USER_ID_KEY] = id
        }
    }

    override suspend fun getUserId(): Int? {
        return sessionDataStore.data.map { data ->
            data[USER_ID_KEY]
        }.first()
    }

    override suspend fun updateAppState(isFirst: Boolean) {
        sessionDataStore.edit { data ->
            data[APP_STATE_KEY] = isFirst
        }
    }

    override suspend fun getAppState(): Boolean? {
        return sessionDataStore.data.map { data ->
            data[APP_STATE_KEY]
        }.first()
    }

}