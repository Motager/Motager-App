package org.ninjaneers.motager.login.presentation

import org.ninjaneers.motager.login.domain.User

interface LoginAction {
    data class OnEmailChange(val email: String) : LoginAction
    data class OnPasswordChange(val password: String) : LoginAction
    data class OnRememberMeToggle(val rememberMe: Boolean) : LoginAction
    data class OnPasswordVisibilityToggle(val isPasswordVisible: Boolean) : LoginAction
    data class OnThemeMenuToggle(val isExpanded: Boolean) : LoginAction
    data class OnLocaleMenuToggle(val isExpanded: Boolean) : LoginAction
    data class OnLogin(val updateUser: (User?) -> Unit, val navigate: () -> Unit) : LoginAction
}