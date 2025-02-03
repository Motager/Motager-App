package org.ninjaneers.motager.dashboard.presentation.orders.presentation

sealed interface OrdersAction {
    data class OnProductSearch(val query: String) : OrdersAction
    data class OnLimitSearch(val limit: Int) : OrdersAction
}