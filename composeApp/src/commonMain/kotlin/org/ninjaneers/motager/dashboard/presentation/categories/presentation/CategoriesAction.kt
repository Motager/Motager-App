package org.ninjaneers.motager.customers.presentation

sealed interface CategoriesAction {
    data class OnProductSearch(val query: String) : CategoriesAction
    data class OnLimitSearch(val limit: Int) : CategoriesAction
    data class OnCategoriesGet(val storeID: Int) : CategoriesAction
}