package org.ninjaneers.motager.core.domain

interface AppSettingsRepository {
    suspend fun getTheme(): String
    suspend fun getLanguage(): String
    suspend fun setAppTheme(theme: String)
    suspend fun setAppLanguage(locale: String)
}