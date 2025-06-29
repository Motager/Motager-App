package org.ninjaneers.motager.dashboard.presentation.orders.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.ninjaneers.motager.core.domain.RemoteError
import org.ninjaneers.motager.core.domain.onError
import org.ninjaneers.motager.core.domain.onSuccess
import org.ninjaneers.motager.core.presentation.toUiText
import org.ninjaneers.motager.dashboard.presentation.orders.domain.OrdersRepository

class OrdersViewModel(
    private val repository: OrdersRepository,
) : ViewModel() {
    private val _state = MutableStateFlow(OrdersScreenState())
    val state = _state.asStateFlow()

    fun onAction(action: OrdersAction) {
        when (action) {
            is OrdersAction.OnLimitSearch -> onLimitSearch(action.limit)
            is OrdersAction.OnProductSearch -> onProductSearch(action.query)
            is OrdersAction.OnOrdersGet -> onOrdersGet(action.storeID)
        }
    }

    private fun onOrdersGet(storeID: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            _state.update {
                it.copy(
                    isLoading = true,
                    isError = null
                )
            }
            repository.getOrders(storeID)
                .onSuccess { orders ->
                    _state.update {
                        it.copy(
                            isLoading = false,
                            isError = null,
                            orders = orders
                        )
                    }
                }
                .onError { error ->
                    if (error == RemoteError.NOT_FOUND)
                        _state.update {
                            it.copy(
                                isLoading = false,
                                isError = null,
                                orders = emptyList()
                            )
                        }
                    else
                        _state.update {
                            it.copy(
                                isLoading = false,
                                isError = error.toUiText(),
                                orders = emptyList()
                            )
                        }
                }
        }
    }
}

private fun onProductSearch(query: String) {
}

private fun onLimitSearch(limit: Int) {
}


