package org.ninjaneers.motager.login.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.ninjaneers.motager.core.data.network.SiteRedirector
import org.ninjaneers.motager.core.data.remote.UserService
import org.ninjaneers.motager.core.domain.onError
import org.ninjaneers.motager.core.domain.onSuccess
import org.ninjaneers.motager.core.presentation.toUiText
import org.ninjaneers.motager.login.domain.AuthenticationRepository
import org.ninjaneers.motager.login.domain.User

class LoginViewModel(
    private val authenticationRepository: AuthenticationRepository,
    private val siteRedirector: SiteRedirector,
    private val userService: UserService
) : ViewModel() {
    private val _state = MutableStateFlow(LoginScreenState())
    val state = _state.asStateFlow()

    fun onAction(action: LoginAction) {
        when (action) {
            is LoginAction.OnEmailChange -> onEmailChange(action.email)
            is LoginAction.OnPasswordChange -> onPasswordChange(action.password)
            is LoginAction.OnRememberMeToggle -> onRememberMeToggle(action.rememberMe)
            is LoginAction.OnPasswordVisibilityToggle -> onPasswordVisibilityToggle(action.isPasswordVisible)
            is LoginAction.OnThemeMenuToggle -> onThemeMenuToggle(action.isExpanded)
            is LoginAction.OnLocaleMenuToggle -> onLocaleMenuToggle(action.isExpanded)
            is LoginAction.OnLogin -> onLogin(
                updateUser = action.updateUser,
                navigate = action.navigate
            )
            LoginAction.OnRedirectToSite -> onSiteRedirect()
            LoginAction.OnStoreDialogToggleVisibility -> onStoreDialogToggleVisibility()
        }
    }

    private fun onStoreDialogToggleVisibility() {
        _state.update {
            it.copy(
                isStoreDialogVisible = !it.isStoreDialogVisible
            )
        }
    }

    private fun onSiteRedirect() {
        siteRedirector.redirectToSite()
    }

    private fun onLogin(updateUser: (User?) -> Unit, navigate: () -> Unit) {
        viewModelScope.launch {
            _state.update {
                it.copy(
                    isLoading = true,
                    error = null
                )
            }
            authenticationRepository.login(
                email = _state.value.email,
                password = _state.value.password
            ).onSuccess { user ->
                if (user.stores.isNotEmpty()) {
                    userService.getUserAvatar(user.name).onSuccess { avatar ->
                        _state.update {
                            it.copy(
                                isLoading = false,
                                error = null,
                                user = user.copy(avatar = avatar),
                            )
                        }
                    }
                    updateUser(_state.value.user)
                    navigate()
                } else {
                    _state.update {
                        it.copy(
                            isLoading = false,
                            user = null,
                            error = null
                        )
                    }
                    onStoreDialogToggleVisibility()
                }
            }.onError { error ->
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

    private fun onPasswordVisibilityToggle(isPasswordVisible: Boolean) {
        _state.update {
            it.copy(
                isPasswordVisible = !isPasswordVisible
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

    private fun onRememberMeToggle(rememberMe: Boolean) {
        _state.update {
            it.copy(
                rememberMe = !rememberMe
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

}