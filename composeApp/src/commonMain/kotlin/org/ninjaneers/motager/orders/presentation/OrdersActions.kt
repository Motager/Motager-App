package org.ninjaneers.motager.orders.presentation

sealed interface OrdersActions {
    data class onProductSearch(val query: String) : OrdersActions
    data class onLimitSearch(val limit: Int) : OrdersActions
}