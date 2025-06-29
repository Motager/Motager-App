package org.ninjaneers.motager.core.data.local

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import kotlinx.cinterop.ExperimentalForeignApi
import okio.Path.Companion.toPath
import org.ninjaneers.motager.core.domain.Language
import org.ninjaneers.motager.core.domain.Theme
import platform.Foundation.NSDocumentDirectory
import platform.Foundation.NSFileManager
import platform.Foundation.NSURL
import platform.Foundation.NSUserDomainMask

@OptIn(ExperimentalForeignApi::class)
@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
actual class SettingsDataStore : SettingsHandler {
    private var settingsDataStore: DataStore<Preferences> =
        PreferenceDataStoreFactory.createWithPath(
            produceFile = {
                val directory: NSURL? = NSFileManager.defaultManager.URLForDirectory(
                    directory = NSDocumentDirectory,
                    inDomain = NSUserDomainMask,
                    appropriateForURL = null,
                    create = false,
                    error = null
                )
                (requireNotNull(directory).path + "/$SETTINGS_FILE_NAME").toPath()
            }
        )

    override suspend fun getAppTheme(): String {
        var theme: String = Theme.System.theme
        settingsDataStore.data.collect { settings ->
            theme = settings[THEME_KEY] ?: Theme.System.theme
        }
        return theme
    }

    override suspend fun getAppLanguage(): String {
        var language: String = Language.English.locale
        settingsDataStore.data.collect { settings ->
            language = settings[LOCALE_KEY] ?: Language.English.locale
        }
        return language
    }

    override suspend fun setAppTheme(theme: String) {
        settingsDataStore.edit { settings ->
            settings[THEME_KEY] = theme
        }
    }

    override suspend fun setAppLanguage(locale: String) {
        settingsDataStore.edit { settings ->
            settings[LOCALE_KEY] = locale
        }
    }
}