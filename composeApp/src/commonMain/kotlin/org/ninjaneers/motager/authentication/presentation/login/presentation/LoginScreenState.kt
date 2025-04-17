package org.ninjaneers.motager.authentication.presentation.login.presentation

import org.ninjaneers.motager.authentication.domain.User
import org.ninjaneers.motager.core.domain.UiText

data class LoginScreenState(
    val isLoading: Boolean = true,
    val error: UiText? = null,
    val email: String = "",
    val password: String = "",
    val user: User? = null,
    val rememberMe: Boolean = false,
    val isPasswordVisible: Boolean = false,
    val isThemeMenuExpanded: Boolean = false,
    val isLocaleMenuExpanded: Boolean = false
)