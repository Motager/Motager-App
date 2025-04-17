package org.ninjaneers.motager.authentication.presentation.signup.presentation

import org.ninjaneers.motager.authentication.domain.User

interface SignupAction {
    data class OnFirstNameChange(val firstName: String) : SignupAction
    data class OnSecondNameChange(val secondName: String) : SignupAction
    data class OnEmailChange(val email: String) : SignupAction
    data class OnPasswordChange(val password: String) : SignupAction
    data class OnPasswordConfirmationChange(val passwordConfirmation: String) : SignupAction
    data class OnThemeMenuToggle(val isExpanded: Boolean) : SignupAction
    data class OnLocaleMenuToggle(val isExpanded: Boolean) : SignupAction
    data class OnPasswordVisibilityToggle(val isPasswordVisible: Boolean) : SignupAction
    data class OnPasswordConfirmationVisibilityToggle(val isPasswordVisible: Boolean) : SignupAction

    data object OnRegisterValidate : SignupAction
    data class OnRegister(val updateUser: (User?) -> Unit, val navigate: () -> Unit) : SignupAction
}