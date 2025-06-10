package org.ninjaneers.motager.dashboard.presentation.categories.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.ninjaneers.motager.core.domain.onError
import org.ninjaneers.motager.core.domain.onSuccess
import org.ninjaneers.motager.core.presentation.toUiText
import org.ninjaneers.motager.customers.presentation.CategoriesAction
import org.ninjaneers.motager.dashboard.presentation.categories.domain.CategoriesRepository

class CategoriesViewModel(
    private val repository: CategoriesRepository
) : ViewModel() {
    private val _state = MutableStateFlow(CategoriesScreenState())
    val state = _state.asStateFlow()

    fun onAction(action: CategoriesAction) {
        when (action) {
            is CategoriesAction.OnLimitSearch -> onLimitSearch(action.limit)
            is CategoriesAction.OnProductSearch -> onProductSearch(action.query)
            is CategoriesAction.OnCategoriesGet -> onCategoriesGet(action.storeID)
        }
    }

    private fun onCategoriesGet(storeID: Int) {
        viewModelScope.launch {
            _state.update {
                it.copy(
                    isLoading = true,
                    isError = null
                )
            }
            repository.getCategories(storeID)
                .onSuccess { categories ->
                    _state.update {
                        it.copy(
                            isLoading = false,
                            isError = null,
                            categories = categories
                        )
                    }
                }
                .onError { error ->
                    _state.update {
                        it.copy(
                            isLoading = false,
                            isError = error.toUiText(),
                            categories = emptyList()
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
