package org.ninjaneers.motager.core.presentation

import org.ninjaneers.motager.core.domain.Language
import org.ninjaneers.motager.core.domain.Theme
import org.ninjaneers.motager.login.domain.Store
import org.ninjaneers.motager.login.domain.User

sealed interface CoreAction {
    data class OnThemeChange(val theme: Theme) : CoreAction
    data class OnLanguageChange(val language: Language) : CoreAction
    data class OnUserChange(val user: User?) : CoreAction
    data class OnStoreChange(val store: Store) : CoreAction
}