package org.ninjaneers.motager.core.data

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import okio.Path.Companion.toPath
import org.ninjaneers.motager.core.domain.Languages
import org.ninjaneers.motager.core.domain.Themes

@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
actual class SettingsDataStore(private val context: Context) : ApplicationSettings {
    private var settingsDataStore: DataStore<Preferences> =
        PreferenceDataStoreFactory.createWithPath(
            produceFile = { context.filesDir.resolve(SETTINGS_FILE_NAME).absolutePath.toPath() }
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
