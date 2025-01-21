package org.ninjaneers.motager.orders.presentation

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class OrdersViewModel : ViewModel() {
    private val _state = MutableStateFlow(OrdersScreenState())
    val state = _state.asStateFlow()

    fun onAction(action: OrdersActions) {
        when (action) {
            is OrdersActions.onLimitSearch -> "TODO()"
            is OrdersActions.onProductSearch -> "TODO()"
        }
    }

    private fun onProductSearch(query: String) {
        /////////////////////////////
    }

    private fun onLimitSearch(limit: Int) {
        //////////////////////////////
    }
}

