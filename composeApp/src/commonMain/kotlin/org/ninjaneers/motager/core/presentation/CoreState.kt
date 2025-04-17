package org.ninjaneers.motager.core.presentation

import org.ninjaneers.motager.authentication.domain.User
import org.ninjaneers.motager.core.domain.Language
import org.ninjaneers.motager.core.domain.Theme

data class CoreState(
    val theme: Theme = Theme.Dark,
    val language: Language = Language.English,
    val user: User? = null
)