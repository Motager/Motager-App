package org.ninjaneers.motager.dashboard.presentation.customers.presentation

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class CustomersViewModel : ViewModel() {
    private val _state = MutableStateFlow(CustomerScreenState())
    val state = _state.asStateFlow()

    fun onAction(action: CustomerActions) {
        when (action) {
            is CustomerActions.onLimitSearch -> CustomerActions.onLimitSearch(action.limit)
            is CustomerActions.onProductSearch -> CustomerActions.onProductSearch(action.query)
        }
    }
}
