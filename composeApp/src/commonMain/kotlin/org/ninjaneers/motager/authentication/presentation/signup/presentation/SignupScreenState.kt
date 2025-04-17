package org.ninjaneers.motager.authentication.presentation.signup.presentation

import org.ninjaneers.motager.authentication.domain.User
import org.ninjaneers.motager.core.domain.UiText

data class SignupScreenState(
    val user: User? = null,
    val isLoading: Boolean = true,
    val error: UiText? = null,
    val firstName: String = "",
    val secondName: String = "",
    val email: String = "",
    val password: String = "",
    val passwordConfirmation: String = "",
    val isThemeMenuExpanded: Boolean = false,
    val isLocaleMenuExpanded: Boolean = false,
    val firstNameError: UiText? = null,
    val secondNameError: UiText? = null,
    val emailError: UiText? = null,
    val passwordError: UiText? = null,
    val passwordConfirmationError: UiText? = null,
    val isPasswordVisible: Boolean = false,
    val isPasswordConfirmationVisible: Boolean = false,
    val isRegisterValid: Boolean = false
)