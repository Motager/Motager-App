package org.ninjaneers.motager.core.presentation

import org.ninjaneers.motager.authentication.domain.User
import org.ninjaneers.motager.core.domain.Language
import org.ninjaneers.motager.core.domain.Theme

sealed interface CoreAction {
    data class OnThemeChange(val theme: Theme) : CoreAction
    data class OnLanguageChange(val language: Language) : CoreAction
    data class OnUserChange(val user: User?) : CoreAction
}