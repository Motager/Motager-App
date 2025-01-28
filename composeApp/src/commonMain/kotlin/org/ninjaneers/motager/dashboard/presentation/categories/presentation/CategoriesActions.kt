package org.ninjaneers.motager.customers.presentation

sealed interface CategoriesActions {
    data class onProductSearch(val query: String) : CategoriesActions
    data class onLimitSearch(val limit: Int) : CategoriesActions
}