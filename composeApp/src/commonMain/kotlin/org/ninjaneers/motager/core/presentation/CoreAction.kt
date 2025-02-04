package org.ninjaneers.motager.core.presentation

import org.ninjaneers.motager.core.domain.Languages
import org.ninjaneers.motager.core.domain.Themes

sealed interface CoreAction {
    data class ChangeTheme(val theme: Themes) : CoreAction
    data class ChangeLanguage(val language: Languages) : CoreAction
}