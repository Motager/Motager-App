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
    private val repository: CustomerRepository,
) : ViewModel() {
    private val _state = MutableStateFlow(CustomerScreenState())
    val state = _state.asStateFlow()

    fun onAction(action: CustomerAction) {
        when (action) {
            is CustomerAction.OnLimitSearch -> onLimitSearch(action.limit)
            is CustomerAction.OnCustomerSearch -> onCustomerSearch(action.query)
            is CustomerAction.OnCustomersGet -> onCustomersGet(action.storeID)
            CustomerAction.OnCustomerDialogToggleVisibility -> onCustomerDialogToggleVisibility()
            is CustomerAction.OnNewCustomerAdd -> onNewCustomerAdd(action.storeID, action.email)
            is CustomerAction.OnCustomerEmailChange -> onCustomerEmailChange(action.email)
        }
    }

    private fun onCustomerEmailChange(email: String) {
        _state.update {
            it.copy(
                customerEmail = email
            )
        }
    }

    private fun onNewCustomerAdd(storeID: Int, email: String) {
        viewModelScope.launch {
            _state.update {
                it.copy(
                    isAddCustomerLoading = true
                )
            }
            repository.createCustomer(storeID, email)
                .onSuccess { customer ->
                    _state.update {
                        it.copy(
                            isAddCustomerLoading = false,
                            customers = it.customers.toMutableList().apply { add(customer) },
                            filteredCustomers = it.filteredCustomers.toMutableList()
                                .apply { add(customer) }
                        )
                    }
                }
                .onError { error ->
                    _state.update {
                        it.copy(
                            isAddCustomerError = error.toUiText()
                        )
                    }
                }
            onCustomerDialogToggleVisibility()
        }
    }

    private fun onCustomerDialogToggleVisibility() {
        _state.update {
            it.copy(
                isCustomerDialogVisible = !it.isCustomerDialogVisible
            )
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
                            customers = customers,
                            filteredCustomers = customers
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

    private fun onCustomerSearch(query: String) {
        _state.update {
            it.copy(
                searchQuery = query,
                filteredCustomers = if (query.isEmpty()) it.customers else
                    it.customers.filter { customer ->
                        customer.email.contains(
                            query,
                            ignoreCase = true
                        ) || customer.totalPayment.toString()
                            .contains(query) || customer.ordersCount.toString().contains(query)
                    }
            )
        }
    }

    private fun onLimitSearch(limit: Int) {

    }
}
