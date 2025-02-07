package org.ninjaneers.motager.core.data.local

import androidx.datastore.preferences.core.stringPreferencesKey

@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
expect class SettingsDataStore : ApplicationSettings

internal const val SETTINGS_FILE_NAME = "prefs.preferences_pb"
internal val THEME_KEY = stringPreferencesKey("Theme")
internal val LOCALE_KEY = stringPreferencesKey("Locale")