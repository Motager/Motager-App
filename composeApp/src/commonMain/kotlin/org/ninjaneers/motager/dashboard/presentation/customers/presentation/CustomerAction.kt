package org.ninjaneers.motager.dashboard.presentation.customers.presentation

sealed interface CustomerAction {
    data class OnProductSearch(val query: String) : CustomerAction
    data class OnLimitSearch(val limit: Int) : CustomerAction
    data class OnCustomersGet(val storeID: Int) : CustomerAction
    data object OnCustomerDialogToggleVisibility : CustomerAction
    data class OnNewCustomerAdd(val storeID: Int, val email: String) : CustomerAction
    data class OnCustomerEmailChange(val email: String) : CustomerAction
}