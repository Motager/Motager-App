package org.ninjaneers.motager.authentication.presentation.signup.presentation

data class SignupScreenState(
    val firstName: String = "",
    val secondName: String = "",
    val email: String = "",
    val password: String = "",
    val passwordConfirmation: String = "",
    val isThemeMenuExpanded: Boolean = false,
    val isLocaleMenuExpanded: Boolean = false
)