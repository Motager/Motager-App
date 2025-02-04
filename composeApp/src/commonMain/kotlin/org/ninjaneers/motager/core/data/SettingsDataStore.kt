package org.ninjaneers.motager.core.data

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences

expect class SettingsDataStore {
    fun createDataStore(): DataStore<Preferences>
}

internal const val SETTINGS_FILE_NAME = "prefs.preferences_pb"