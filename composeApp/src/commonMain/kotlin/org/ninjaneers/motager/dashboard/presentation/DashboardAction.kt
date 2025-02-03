package org.ninjaneers.motager.dashboard.presentation

sealed interface DashboardAction {
    data object OpenDrawer : DashboardAction
    data object CloseDrawer : DashboardAction
}