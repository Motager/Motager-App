package org.ninjaneers.motager.dashboard.presentation

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class DashboardViewModel : ViewModel() {
    private val _state = MutableStateFlow(DashboardState())
    val state = _state.asStateFlow()

    suspend fun onAction(action: DashboardAction) {
        when (action) {
            DashboardAction.CloseDrawer -> {
                closeDrawer()
            }

            DashboardAction.OpenDrawer -> {
                openDrawer()
            }
        }
    }

    private suspend fun openDrawer() {
        _state.value.drawerState.open()
    }

    private suspend fun closeDrawer() {
        _state.value.drawerState.close()
    }
}