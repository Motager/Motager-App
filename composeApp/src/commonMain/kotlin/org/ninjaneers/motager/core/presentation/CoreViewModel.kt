package org.ninjaneers.motager.core.presentation


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.ninjaneers.motager.core.domain.AppSettingsRepository
import org.ninjaneers.motager.core.domain.Languages
import org.ninjaneers.motager.core.domain.Themes

class CoreViewModel(private val settingsRepository: AppSettingsRepository) : ViewModel() {
    private val _state = MutableStateFlow(CoreState())
    val state = _state.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            _state.update {
                it.copy(
                    theme = when (settingsRepository.getTheme()) {
                        "light" -> Themes.Light
                        "dark" -> Themes.Dark
                        else -> Themes.System
                    },
                    language = when (settingsRepository.getLanguage()) {
                        "en" -> Languages.English
                        "ar" -> Languages.Arabic
                        else -> Languages.English
                    }
                )
            }
        }
    }

    fun onAction(action: CoreAction) {
        when (action) {
            is CoreAction.ChangeLanguage -> changeLanguage(action.language)
            is CoreAction.ChangeTheme -> changeTheme(action.theme)
        }
    }

    private fun changeTheme(theme: Themes) {
        viewModelScope.launch(Dispatchers.IO) {
            settingsRepository.setAppTheme(theme.theme)
        }
        _state.update { it.copy(theme = theme) }
    }

    private fun changeLanguage(language: Languages) {
        viewModelScope.launch(Dispatchers.IO) {
            settingsRepository.setAppLanguage(language.locale)
        }
        _state.update { it.copy(language = language) }
    }
}