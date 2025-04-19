package org.ninjaneers.motager.dashboard.presentation

import org.ninjaneers.motager.dashboard.domain.DashboardContent

sealed interface DashboardAction {
    data object OpenNavigationDrawer : DashboardAction
    data object CloseNavigationDrawer : DashboardAction
    data class OnContentChange(val content: DashboardContent, val index: Int = 0) : DashboardAction
    data class OnThemeMenuToggle(val isExpanded: Boolean) : DashboardAction
    data class OnLocaleMenuToggle(val isExpanded: Boolean) : DashboardAction
}