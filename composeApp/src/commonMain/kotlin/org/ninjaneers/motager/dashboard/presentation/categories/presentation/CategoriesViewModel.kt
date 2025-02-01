package org.ninjaneers.motager.dashboard.presentation.categories.presentation

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import org.ninjaneers.motager.customers.presentation.CategoriesAction

class CategoriesViewModel : ViewModel() {
    private val _state = MutableStateFlow(CategoriesScreenState())
    val state = _state.asStateFlow()

    fun onAction(action: CategoriesAction) {
        when (action) {
            is CategoriesAction.OnLimitSearch -> onLimitSearch(action.limit)
            is CategoriesAction.OnProductSearch -> onProductSearch(action.query)
        }
    }

    private fun onProductSearch(query: String) {

    }

    private fun onLimitSearch(limit: Int) {
    }
}
