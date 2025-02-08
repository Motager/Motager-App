package org.ninjaneers.motager.authentication.presentation.login.presentation

data class LoginScreenState(
    val email: String = "",
    val password: String = "",
    val rememberMe: Boolean = false,
    val isThemeMenuExpanded: Boolean = false,
    val isLocaleMenuExpanded: Boolean = false
)