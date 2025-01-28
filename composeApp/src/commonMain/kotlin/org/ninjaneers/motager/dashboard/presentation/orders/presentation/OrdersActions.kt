package org.ninjaneers.motager.dashboard.presentation.orders.presentation

sealed interface OrdersActions {
    data class onProductSearch(val query: String) : OrdersActions
    data class onLimitSearch(val limit: Int) : OrdersActions
}