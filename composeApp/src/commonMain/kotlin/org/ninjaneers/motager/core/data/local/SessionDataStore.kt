package org.ninjaneers.motager.core.data.local

import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey

@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
expect class SessionDataStore : SessionHandler

internal const val SESSION_FILE_NAME = "session.preferences_pb"
internal val ACCESS_TOKEN_KEY = stringPreferencesKey("AccessToken")
internal val REFRESH_TOKEN_KEY = stringPreferencesKey("RefreshToken")
internal val USER_ID_KEY = intPreferencesKey("UserId")
internal val APP_STATE_KEY = booleanPreferencesKey("StateKey")