package org.ninjaneers.motager.login.presentation

import org.ninjaneers.motager.core.domain.UiText
import org.ninjaneers.motager.login.domain.User

data class LoginScreenState(
    val isLoading: Boolean = false,
    val error: UiText? = null,
    val email: String = "",
    val password: String = "",
    val user: User? = null,
    val rememberMe: Boolean = false,
    val isPasswordVisible: Boolean = false,
    val isThemeMenuExpanded: Boolean = false,
    val isLocaleMenuExpanded: Boolean = false,
    val isStoreDialogVisible: Boolean = false
)