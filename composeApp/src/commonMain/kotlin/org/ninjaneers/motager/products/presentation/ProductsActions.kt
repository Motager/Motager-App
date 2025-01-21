package org.ninjaneers.motager.products.presentation

sealed interface ProductsActions {
    data class onProductSearch(val query: String) : ProductsActions
    data class onLimitSearch(val limit: Int) : ProductsActions
}