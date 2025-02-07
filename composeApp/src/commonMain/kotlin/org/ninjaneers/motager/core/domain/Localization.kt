package org.ninjaneers.motager.core.domain

expect class Localization {
    fun changeLanguage(locale: String)
}