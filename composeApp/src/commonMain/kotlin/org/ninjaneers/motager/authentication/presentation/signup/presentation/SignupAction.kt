package org.ninjaneers.motager.authentication.presentation.signup.presentation

interface SignupAction {
    data class OnFirstNameChange(val firstName: String) : SignupAction
    data class OnSecondNameChange(val secondName: String) : SignupAction
    data class OnEmailChange(val email: String) : SignupAction
    data class OnPasswordChange(val password: String) : SignupAction
    data class OnPasswordConfirmationChange(val passwordConfirmation: String) : SignupAction
    data class OnThemeMenuToggle(val isExpanded: Boolean) : SignupAction
    data class OnLocaleMenuToggle(val isExpanded: Boolean) : SignupAction
    data class OnPasswordConfirmationVisibilityToggle(val rememberMe: Boolean) : SignupAction
    data class OnPasswordVisibilityToggle(val isPasswordVisible: Boolean) : SignupAction
    data class OnEmailValidate(val email: String) : SignupAction
    data class OnFirstNameValidate(val firstName: String) : SignupAction
    data class OnSecondNameValidate(val secondName: String) : SignupAction
    data class OnPasswordValidate(val password: String) : SignupAction
    data class OnConfirmPasswordValidate(
        val password: String,
        val confirmedPassword: String
    ) : SignupAction

    data object OnRegisterValidate : SignupAction
    data object OnRegister : SignupAction
}