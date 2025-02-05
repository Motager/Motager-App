package org.ninjaneers.motager.core.data

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
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
        return settingsDataStore.data.map { settings ->
            settings[THEME_KEY] ?: Themes.System.theme
        }.first()
    }

    override suspend fun getAppLanguage(): String {
        return settingsDataStore.data.map { settings ->
            settings[LOCALE_KEY] ?: Languages.English.locale
        }.first()
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
