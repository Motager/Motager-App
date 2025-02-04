package org.ninjaneers.motager.core.presentation

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.ninjaneers.motager.core.domain.Languages
import org.ninjaneers.motager.core.domain.Themes

class CoreViewModel(private val settingsDataStore: DataStore<Preferences>) : ViewModel() {
    private val _state = MutableStateFlow(CoreState())
    val state = _state.asStateFlow()

    init {
        val themeKey = stringPreferencesKey("Theme")
        val localeKey = stringPreferencesKey("Locale")
//        var theme: String? = null
//        var locale: String? = null
        viewModelScope.launch {
            settingsDataStore.data.collect { settings ->
                _state.update {
                    it.copy(
                        theme = when (settings[themeKey]) {
                            Themes.Light.theme -> Themes.Light
                            Themes.Dark.theme -> Themes.Dark
                            else -> Themes.System
                        },
                        language = when (settings[localeKey]) {
                            Languages.English.locale -> Languages.English
                            Languages.Arabic.locale -> Languages.Arabic
                            else -> Languages.English
                        }
                    )
                }
            }
        }
    }

    fun changeTheme(theme: Themes) {
        val themeKey = stringPreferencesKey("Theme")
        viewModelScope.launch {
            settingsDataStore.edit {
                it[themeKey] = theme.theme
            }
        }
        _state.update { it.copy(theme = theme) }
    }
}