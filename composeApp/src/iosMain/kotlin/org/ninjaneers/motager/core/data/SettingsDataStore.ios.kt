@file:OptIn(ExperimentalForeignApi::class)

package org.ninjaneers.motager.core.data

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import kotlinx.cinterop.ExperimentalForeignApi
import okio.Path.Companion.toPath
import org.ninjaneers.motager.core.domain.Languages
import org.ninjaneers.motager.core.domain.Themes
import platform.Foundation.NSDocumentDirectory
import platform.Foundation.NSFileManager
import platform.Foundation.NSURL
import platform.Foundation.NSUserDomainMask

@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
actual class SettingsDataStore : ApplicationSettings {
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
        var theme: String = Themes.System.theme
        settingsDataStore.data.collect { settings ->
            theme = settings[THEME_KEY] ?: Themes.System.theme
        }
        return theme
    }

    override suspend fun getAppLanguage(): String {
        var language: String = Languages.English.locale
        settingsDataStore.data.collect { settings ->
            language = settings[LOCALE_KEY] ?: Languages.English.locale
        }
        return language
    }
}