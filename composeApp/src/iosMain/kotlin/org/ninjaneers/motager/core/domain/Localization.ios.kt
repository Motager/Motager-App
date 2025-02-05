package org.ninjaneers.motager.core.domain

import platform.Foundation.NSUserDefaults

actual class Localization {
    actual fun changeLanguage(locale: String) {
        NSUserDefaults.standardUserDefaults.setObject(
            value = arrayListOf(locale),
            forKey = "AppLanguages"
        )
    }
}