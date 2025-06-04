package org.ninjaneers.motager.core.presentation


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.ninjaneers.motager.authentication.domain.User
import org.ninjaneers.motager.core.domain.AppSettingsRepository
import org.ninjaneers.motager.core.domain.Language
import org.ninjaneers.motager.core.domain.Localization
import org.ninjaneers.motager.core.domain.Theme

class CoreViewModel(
    private val settingsRepository: AppSettingsRepository,
    private val localization: Localization
) : ViewModel() {
    private val _state = MutableStateFlow(CoreState())
    val state = _state.asStateFlow()

    init {
        fetchAppSettings()
    }

    private fun fetchAppSettings() {
        viewModelScope.launch(Dispatchers.IO) {
            _state.update {
                it.copy(
                    theme = when (settingsRepository.getTheme()) {
                        "light" -> Theme.Light
                        "dark" -> Theme.Dark
                        else -> Theme.System
                    },
                    language = when (settingsRepository.getLanguage()) {
                        "en" -> Language.English
                        "ar" -> Language.Arabic
                        else -> Language.English
                    }
                )
            }
            localization.changeLanguage(_state.value.language.locale)
        }
    }

    fun onAction(action: CoreAction) {
        when (action) {
            is CoreAction.OnLanguageChange -> changeLanguage(action.language)
            is CoreAction.OnThemeChange -> changeTheme(action.theme)
            is CoreAction.OnUserChange -> onUserChange(action.user)
        }
    }

    private fun onUserChange(user: User?) {
        _state.update {
            it.copy(
                user = user
            )
        }
    }

    private fun changeTheme(theme: Theme) {
        viewModelScope.launch(Dispatchers.IO) {
            settingsRepository.setAppTheme(theme.theme)
        }
        _state.update { it.copy(theme = theme) }
    }

    private fun changeLanguage(language: Language) {
        viewModelScope.launch(Dispatchers.IO) {
            settingsRepository.setAppLanguage(language.locale)
        }
        localization.changeLanguage(language.locale)
        _state.update { it.copy(language = language) }
    }
}