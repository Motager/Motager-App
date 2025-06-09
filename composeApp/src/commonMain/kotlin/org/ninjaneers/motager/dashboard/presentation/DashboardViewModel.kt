package org.ninjaneers.motager.dashboard.presentation

import androidx.lifecycle.ViewModel
import co.touchlab.kermit.Logger
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import org.ninjaneers.motager.dashboard.domain.DashboardContent

class DashboardViewModel : ViewModel() {
    private val _state = MutableStateFlow(DashboardState())
    val state = _state.asStateFlow()

    suspend fun onAction(action: DashboardAction) {
        when (action) {
            is DashboardAction.CloseNavigationDrawer -> {
                closeNavigationDrawer()
            }

            is DashboardAction.OpenNavigationDrawer -> {
                openNavigationDrawer()
            }

            is DashboardAction.OnContentChange -> changeContent(action.content, action.index)
            is DashboardAction.OnLocaleMenuToggle -> toggleLocaleMenu(action.isExpanded)
            is DashboardAction.OnThemeMenuToggle -> toggleThemeMenu(action.isExpanded)
            DashboardAction.OnStoresMenuToggle -> onStoresMenuToggle()
        }
    }

    private fun onStoresMenuToggle() {
        _state.update {
            it.copy(
                isStoresMenuExpanded = !it.isStoresMenuExpanded
            )
        }
    }

    private suspend fun openNavigationDrawer() {
        _state.value.drawerState.open()
    }

    private suspend fun closeNavigationDrawer() {
        _state.value.drawerState.close()
    }

    private fun changeContent(content: DashboardContent, index: Int) {
        _state.update {
            it.copy(
                content = content,
                selectedIndex = index
            )
        }
    }

    private fun toggleThemeMenu(isExpanded: Boolean) {
        Logger.i(tag = "Theme Menu", messageString = "toggle")
        _state.update {
            it.copy(
                isThemeMenuExpanded = !isExpanded
            )
        }
    }

    private fun toggleLocaleMenu(isExpanded: Boolean) {
        _state.update {
            it.copy(
                isLocaleMenuExpanded = !isExpanded
            )
        }
    }
}