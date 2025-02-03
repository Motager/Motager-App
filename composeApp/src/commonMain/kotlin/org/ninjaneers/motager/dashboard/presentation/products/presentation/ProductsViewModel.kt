package org.ninjaneers.motager.dashboard.presentation.products.presentation

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class ProductsViewModel : ViewModel() {
    private val _state = MutableStateFlow(ProductsScreenState())
    val state = _state.asStateFlow()

    fun onAction(action: ProductsAction) {
        when (action) {
            is ProductsAction.OnLimitSearch -> onLimitSearch(action.limit)
            is ProductsAction.OnProductSearch -> onProductSearch(action.query)
        }
    }

    private fun onProductSearch(query: String) {

    }

    private fun onLimitSearch(limit: Int) {

    }
}