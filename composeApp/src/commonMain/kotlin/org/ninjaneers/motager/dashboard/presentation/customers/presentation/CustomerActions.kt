package org.ninjaneers.motager.dashboard.presentation.customers.presentation

sealed interface CustomerActions {
    data class onProductSearch(val query: String) :
        org.ninjaneers.motager.dashboard.presentation.customers.presentation.CustomerActions

    data class onLimitSearch(val limit: Int) :
        org.ninjaneers.motager.dashboard.presentation.customers.presentation.CustomerActions
}