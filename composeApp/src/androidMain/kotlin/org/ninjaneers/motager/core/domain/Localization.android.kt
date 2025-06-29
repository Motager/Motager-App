package org.ninjaneers.motager.core.domain

import android.content.Context
import android.os.LocaleList
import java.util.Locale

actual class Localization(private val context: Context) {
    actual fun changeLanguage(locale: String) {
        val _locale = Locale(locale)
        Locale.setDefault(_locale)
        val config = context.resources.configuration
        config.setLocales(LocaleList(_locale))
    }
}