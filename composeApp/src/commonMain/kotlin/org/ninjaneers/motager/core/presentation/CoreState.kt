package org.ninjaneers.motager.core.presentation

import org.ninjaneers.motager.core.domain.Language
import org.ninjaneers.motager.core.domain.Theme
import org.ninjaneers.motager.login.domain.User

data class CoreState(
    val theme: Theme = Theme.Dark,
    val language: Language = Language.English,
    val user: User? = null
)