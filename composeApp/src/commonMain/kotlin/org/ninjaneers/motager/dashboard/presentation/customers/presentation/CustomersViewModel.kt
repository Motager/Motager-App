package org.ninjaneers.motager.dashboard.presentation.customers.presentation

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class CustomersViewModel : ViewModel() {
    private val _state = MutableStateFlow(CustomerScreenState())
    val state = _state.asStateFlow()

    fun onAction(action: CustomerAction) {
        when (action) {
            is CustomerAction.OnLimitSearch -> onLimitSearch(action.limit)
            is CustomerAction.OnProductSearch -> onProductSearch(action.query)
        }
    }

    private fun onProductSearch(query: String) {

    }

    private fun onLimitSearch(limit: Int) {

    }
}
