package org.ninjaneers.motager.dashboard.presentation.products.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.ninjaneers.motager.core.domain.RemoteError
import org.ninjaneers.motager.core.domain.onError
import org.ninjaneers.motager.core.domain.onSuccess
import org.ninjaneers.motager.core.presentation.toUiText
import org.ninjaneers.motager.dashboard.presentation.products.domain.ProductsRepository

class ProductsViewModel(
    private val repository: ProductsRepository
) : ViewModel() {
    private val _state = MutableStateFlow(ProductsState())
    val state = _state.asStateFlow()

    fun onAction(action: ProductsAction) {
        when (action) {
            is ProductsAction.OnLimitSearch -> onLimitSearch(action.limit)
            is ProductsAction.OnProductSearch -> onProductSearch(action.query)
            is ProductsAction.OnProductsGet -> onProductsGet(action.storeID)
        }
    }

    private fun onProductsGet(storeID: Int) {
        viewModelScope.launch {
            _state.update {
                it.copy(
                    isLoading = true,
                    isError = null
                )
            }
            repository.getProducts(storeID)
                .onSuccess { products ->
                    _state.update {
                        it.copy(
                            products = products,
                            isLoading = false,
                            isError = null
                        )
                    }
                }
                .onError { error ->
                    if (error == RemoteError.NOT_FOUND)
                        _state.update {
                            it.copy(
                                products = emptyList(),
                                isLoading = false,
                                isError = null
                            )
                        }
                    else
                        _state.update {
                            it.copy(
                                isLoading = false,
                                isError = error.toUiText()
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