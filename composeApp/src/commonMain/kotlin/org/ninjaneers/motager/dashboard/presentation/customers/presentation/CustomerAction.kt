package org.ninjaneers.motager.dashboard.presentation.customers.presentation

sealed interface CustomerAction {
    data class OnProductSearch(val query: String) : CustomerAction

    data class OnLimitSearch(val limit: Int) : CustomerAction
}