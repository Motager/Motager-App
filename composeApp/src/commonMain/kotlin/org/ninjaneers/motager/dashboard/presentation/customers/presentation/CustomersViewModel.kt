package org.ninjaneers.motager.dashboard.presentation.customers.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.ninjaneers.motager.core.domain.onError
import org.ninjaneers.motager.core.domain.onSuccess
import org.ninjaneers.motager.core.presentation.toUiText
import org.ninjaneers.motager.dashboard.presentation.customers.domain.CustomerRepository

class CustomersViewModel(
    private val repository: CustomerRepository
) : ViewModel() {
    private val _state = MutableStateFlow(CustomerScreenState())
    val state = _state.asStateFlow()

    fun onAction(action: CustomerAction) {
        when (action) {
            is CustomerAction.OnLimitSearch -> onLimitSearch(action.limit)
            is CustomerAction.OnProductSearch -> onProductSearch(action.query)
            is CustomerAction.OnCustomersGet -> onCustomersGet(action.storeID)
        }
    }

    private fun onCustomersGet(storeID: Int) {
        viewModelScope.launch {
            _state.update {
                it.copy(
                    isLoading = true,
                    isError = null
                )
            }
            repository.getCustomers(storeID)
                .onSuccess { customers ->
                    _state.update {
                        it.copy(
                            isLoading = false,
                            isError = null,
                            customers = customers
                        )
                    }
                }
                .onError { error ->
                    _state.update {
                        it.copy(
                            isLoading = false,
                            customers = emptyList(),
                            isError = error.toUiText()
                        )
                    }
                }
        }
    }

    private fun onProductSearch(query: String) {

    }

    private fun onLimitSearch(limit: Int) {

    }
}
