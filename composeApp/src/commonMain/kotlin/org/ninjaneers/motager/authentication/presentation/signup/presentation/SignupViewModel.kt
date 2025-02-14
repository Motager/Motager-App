package org.ninjaneers.motager.authentication.presentation.signup.presentation

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class SignupViewModel : ViewModel() {
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
}
