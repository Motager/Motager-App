package org.ninjaneers.motager.customers.presentation

sealed interface CustomerActions {
    data class onProductSearch(val query: String) : CustomerActions
    data class onLimitSearch(val limit: Int) : CustomerActions
}