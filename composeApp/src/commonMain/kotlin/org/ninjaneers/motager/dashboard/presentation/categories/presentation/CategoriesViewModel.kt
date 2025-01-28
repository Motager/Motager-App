package org.ninjaneers.motager.dashboard.presentation.categories.presentation

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import org.ninjaneers.motager.customers.presentation.CategoriesActions

class CategoriesViewModel : ViewModel() {
    private val _state = MutableStateFlow(CategoriesScreenState())
    val state = _state.asStateFlow()

    fun onAction(action: CategoriesActions) {
        when (action) {
            is CategoriesActions.onLimitSearch -> CategoriesActions.onLimitSearch(action.limit)
            is CategoriesActions.onProductSearch -> CategoriesActions.onProductSearch(action.query)
            else -> {}
        }
    }
}
