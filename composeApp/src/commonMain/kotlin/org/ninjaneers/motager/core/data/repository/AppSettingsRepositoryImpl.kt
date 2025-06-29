package org.ninjaneers.motager.core.data.repository

import org.ninjaneers.motager.core.data.local.SettingsHandler
import org.ninjaneers.motager.core.domain.AppSettingsRepository

class AppSettingsRepositoryImpl(
    private val settingsSource: SettingsHandler
) : AppSettingsRepository {
    override suspend fun getTheme(): String {
        return settingsSource.getAppTheme()
    }

    override suspend fun getLanguage(): String {
        return settingsSource.getAppLanguage()
    }

    override suspend fun setAppTheme(theme: String) {
        return settingsSource.setAppTheme(theme)
    }

    override suspend fun setAppLanguage(locale: String) {
        return settingsSource.setAppLanguage(locale)
    }
}