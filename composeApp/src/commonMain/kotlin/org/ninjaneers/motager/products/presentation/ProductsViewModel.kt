package org.ninjaneers.motager.products.presentation

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class ProductsViewModel : ViewModel() {
    private val _state = MutableStateFlow(ProductsScreenState())
    val state = _state.asStateFlow()

    fun onAction(action: ProductsActions) {
        when (action) {
            is ProductsActions.onLimitSearch -> onLimitSearch(action.limit)
            is ProductsActions.onProductSearch -> onProductSearch(action.query)
        }
    }

    private fun onProductSearch(query: String) {

    }

    private fun onLimitSearch(limit: Int) {

    }
}