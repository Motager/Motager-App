package org.ninjaneers.motager.dashboard.presentation

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import org.ninjaneers.motager.dashboard.domain.DashboardContent

class DashboardViewModel : ViewModel() {
    private val _state = MutableStateFlow(DashboardState())
    val state = _state.asStateFlow()

    suspend fun onAction(action: DashboardAction) {
        when (action) {
            DashboardAction.CloseNavigationDrawer -> {
                closeNavigationDrawer()
            }

            DashboardAction.OpenNavigationDrawer -> {
                openNavigationDrawer()
            }

            is DashboardAction.OnContentChange -> changeContent(action.content)
        }
    }

    private suspend fun openNavigationDrawer() {
        _state.value.drawerState.open()
    }

    private suspend fun closeNavigationDrawer() {
        _state.value.drawerState.close()
    }

    private fun changeContent(content: DashboardContent) {
        _state.update {
            it.copy(
                content = content
            )
        }
    }
}