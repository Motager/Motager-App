package org.ninjaneers.motager.authentication.presentation.signup.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.ninjaneers.motager.authentication.domain.AuthenticationRepository
import org.ninjaneers.motager.authentication.presentation.signup.domain.UserDataValidator
import org.ninjaneers.motager.core.domain.onError
import org.ninjaneers.motager.core.domain.onSuccess

class SignupViewModel(
    private val userValidator: UserDataValidator,
    private val authenticationRepository: AuthenticationRepository
) : ViewModel() {
    private val _state = MutableStateFlow(SignupScreenState())
    val state = _state.asStateFlow()

    fun onAction(action: SignupAction) {
        when (action) {
            is SignupAction.OnFirstNameChange -> onFirstNameChange(action.firstName)
            is SignupAction.OnSecondNameChange -> onSecondNameChange(action.secondName)
            is SignupAction.OnEmailChange -> onEmailChange(action.email)
            is SignupAction.OnPasswordChange -> onPasswordChange(action.password)
            is SignupAction.OnPasswordConfirmationChange -> onPasswordConfirmationChange(action.passwordConfirmation)
            is SignupAction.OnThemeMenuToggle -> onThemeMenuToggle(action.isExpanded)
            is SignupAction.OnLocaleMenuToggle -> onLocaleMenuToggle(action.isExpanded)
            is SignupAction.OnPasswordConfirmationVisibilityToggle -> onPasswordConfirmationVisibilityToggle(
                action.rememberMe
            )

            is SignupAction.OnEmailValidate -> onEmailValidate(action.email)
            is SignupAction.OnFirstNameValidate -> onFirstNameValidate(action.firstName)
            is SignupAction.OnSecondNameValidate -> onSecondNameValidate(action.secondName)
            is SignupAction.OnPasswordValidate -> onPasswordValidate(action.password)
            is SignupAction.OnConfirmPasswordValidate -> onConfirmPasswordValidate(
                action.password, action.confirmedPassword
            )

            is SignupAction.OnRegisterValidate -> onRegisterValidate()
            is SignupAction.OnRegister -> onRegister()
        }
    }

    private fun onRegister() {
        viewModelScope.launch(Dispatchers.IO) {
            _state.value.apply {
                if (isRegisterValid) {
                    authenticationRepository.register(firstName, secondName, email, password)
                        .onSuccess {}
                        .onError {}
                }
            }
        }
    }

    private fun onRegisterValidate() {
        onFirstNameValidate(_state.value.firstName)
        onSecondNameValidate(_state.value.secondName)
        onEmailValidate(_state.value.email)
        onPasswordValidate(_state.value.password)
        onConfirmPasswordValidate(_state.value.password, _state.value.passwordConfirmation)
        _state.update {
            it.copy(
                isRegisterValid = it.firstNameError == null &&
                        it.secondNameError == null &&
                        it.emailError == null && it.passwordError == null &&
                        it.passwordConfirmationError == null
            )
        }
    }

    private fun onPasswordConfirmationVisibilityToggle(rememberMe: Boolean) {
        _state.update {
            it.copy(
                isPasswordConfirmationVisible = rememberMe
            )
        }
    }

    private fun onLocaleMenuToggle(isExpanded: Boolean) {
        _state.update {
            it.copy(
                isLocaleMenuExpanded = !isExpanded
            )
        }
    }

    private fun onThemeMenuToggle(isExpanded: Boolean) {
        _state.update {
            it.copy(
                isThemeMenuExpanded = !isExpanded
            )
        }
    }

    private fun onFirstNameChange(firstName: String) {
        _state.update {
            it.copy(
                firstName = firstName
            )
        }
    }

    private fun onSecondNameChange(secondName: String) {
        _state.update {
            it.copy(
                secondName = secondName
            )
        }
    }

    private fun onEmailChange(email: String) {
        _state.update {
            it.copy(
                email = email
            )
        }
    }

    private fun onPasswordChange(password: String) {
        _state.update {
            it.copy(
                password = password
            )
        }
    }

    private fun onPasswordConfirmationChange(passwordConfirmation: String) {
        _state.update {
            it.copy(
                passwordConfirmation = passwordConfirmation
            )
        }
    }

    private fun onEmailValidate(email: String) {
        userValidator.onEmailValidate(email)
            .onSuccess {
                _state.update {
                    it.copy(
                        emailError = null
                    )
                }
            }.onError { error ->
                _state.update {
                    it.copy(
                        emailError = error.toUiText()
                    )
                }
            }
    }

    private fun onFirstNameValidate(name: String) {
        userValidator.onNamesValidate(name)
            .onSuccess {
                _state.update {
                    it.copy(
                        firstNameError = null
                    )
                }
            }.onError { error ->
                _state.update {
                    it.copy(
                        firstNameError = error.toUiText()
                    )
                }
            }
    }

    private fun onSecondNameValidate(name: String) {
        userValidator.onNamesValidate(name)
            .onSuccess {
                _state.update {
                    it.copy(
                        secondNameError = null
                    )
                }
            }.onError { error ->
                _state.update {
                    it.copy(
                        secondNameError = error.toUiText()
                    )
                }
            }
    }

    private fun onPasswordValidate(password: String) {
        userValidator.onPasswordValidate(password)
            .onSuccess {
                _state.update {
                    it.copy(
                        passwordError = null
                    )
                }
            }.onError { error ->
                _state.update {
                    it.copy(
                        passwordError = error.toUiText()
                    )
                }
            }
    }

    private fun onConfirmPasswordValidate(password: String, confirmedPassword: String) {
        userValidator.onConfirmPasswordValidate(password, confirmedPassword)
            .onSuccess {
                _state.update {
                    it.copy(
                        passwordConfirmationError = null
                    )
                }
            }.onError { error ->
                _state.update {
                    it.copy(
                        passwordConfirmationError = error.toUiText()
                    )
                }
            }
    }

}
