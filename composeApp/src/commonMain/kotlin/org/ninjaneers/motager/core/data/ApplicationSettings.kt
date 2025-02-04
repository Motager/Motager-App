package org.ninjaneers.motager.core.data


interface ApplicationSettings {
    suspend fun getAppTheme(): String
    suspend fun getAppLanguage(): String
    suspend fun setAppTheme(theme: String)
    suspend fun setAppLanguage(locale: String)
}