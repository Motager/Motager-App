package org.ninjaneers.motager.core.presentation

import org.ninjaneers.motager.core.domain.Languages
import org.ninjaneers.motager.core.domain.Themes

data class CoreState(
    val theme: Themes = Themes.Dark,
    val language: Languages = Languages.English
)