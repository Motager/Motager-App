package org.ninjaneers.motager.core.presentation

import org.ninjaneers.motager.core.domain.Language
import org.ninjaneers.motager.core.domain.Theme

sealed interface CoreAction {
    data class ChangeTheme(val theme: Theme) : CoreAction
    data class ChangeLanguage(val language: Language) : CoreAction
}