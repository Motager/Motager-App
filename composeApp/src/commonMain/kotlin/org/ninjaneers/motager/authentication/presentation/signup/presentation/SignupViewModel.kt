package org.ninjaneers.motager.authentication.presentation.signup.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.ninjaneers.motager.authentication.domain.AuthenticationUseCase
import org.ninjaneers.motager.authentication.domain.User
import org.ninjaneers.motager.authentication.domain.UserDataValidator
import org.ninjaneers.motager.authentication.presentation.components.toUiText
import org.ninjaneers.motager.core.domain.onError
import org.ninjaneers.motager.core.domain.onSuccess
import org.ninjaneers.motager.core.presentation.toUiText

class SignupViewModel(
    private val userValidator: UserDataValidator,
    private val authenticationUseCase: AuthenticationUseCase
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
                action.isPasswordVisible
            )
            is SignupAction.OnPasswordVisibilityToggle -> onPasswordVisibilityToggle(action.isPasswordVisible)
            is SignupAction.OnRegisterValidate -> onRegisterValidate()
            is SignupAction.OnRegister -> onRegister(
                updateUser = action.updateUser,
                navigate = action.navigate
            )
        }
    }

    private fun onRegister(
        updateUser: (User?) -> Unit,
        navigate: () -> Unit
    ) {
        viewModelScope.launch {
            _state.value.apply {
                if (isRegisterValid) {
                    authenticationUseCase.register(firstName, secondName, email, password)
                        .onSuccess { user ->
                            _state.update {
                                it.copy(
                                    isLoading = false,
                                    error = null,
                                    user = user
                                )
                            }
                            updateUser(_state.value.user)
                            navigate()
                        }
                        .onError { error ->
                            _state.update {
                                it.copy(
                                    isLoading = false,
                                    user = null,
                                    error = error.toUiText()
                                )
                            }
                            updateUser(null)

                        }
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

    private fun onPasswordVisibilityToggle(passwordVisible: Boolean) {
        _state.update {
            it.copy(
                isPasswordVisible = !passwordVisible
            )
        }
    }

    private fun onPasswordConfirmationVisibilityToggle(isPasswordVisible: Boolean) {
        _state.update {
            it.copy(
                isPasswordConfirmationVisible = !isPasswordVisible
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
        onFirstNameValidate(firstName)
    }

    private fun onSecondNameChange(secondName: String) {
        _state.update {
            it.copy(
                secondName = secondName
            )
        }
        onSecondNameValidate(secondName)
    }

    private fun onEmailChange(email: String) {
        _state.update {
            it.copy(
                email = email
            )
        }
        onEmailValidate(email)
    }

    private fun onPasswordChange(password: String) {
        _state.update {
            it.copy(
                password = password
            )
        }
        onPasswordValidate(password)
    }

    private fun onPasswordConfirmationChange(passwordConfirmation: String) {
        _state.update {
            it.copy(
                passwordConfirmation = passwordConfirmation
            )
        }
        onConfirmPasswordValidate(_state.value.password, passwordConfirmation)
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
