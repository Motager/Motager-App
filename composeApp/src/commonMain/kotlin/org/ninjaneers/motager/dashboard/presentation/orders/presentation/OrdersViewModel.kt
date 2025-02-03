package org.ninjaneers.motager.dashboard.presentation.orders.presentation

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class OrdersViewModel : ViewModel() {
    private val _state = MutableStateFlow(OrdersScreenState())
    val state = _state.asStateFlow()

    fun onAction(action: OrdersAction) {
        when (action) {
            is OrdersAction.OnLimitSearch -> onLimitSearch(action.limit)
            is OrdersAction.OnProductSearch -> onProductSearch(action.query)
        }
    }

    private fun onProductSearch(query: String) {
    }

    private fun onLimitSearch(limit: Int) {
    }
}

