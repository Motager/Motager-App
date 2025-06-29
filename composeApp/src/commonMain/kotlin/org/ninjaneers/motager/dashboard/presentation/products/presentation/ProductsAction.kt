package org.ninjaneers.motager.dashboard.presentation.products.presentation

sealed interface ProductsAction {
    data class OnProductSearch(val query: String) : ProductsAction
    data class OnLimitSearch(val limit: Int) : ProductsAction
    data class OnProductsGet(val storeID: Int) : ProductsAction
}