package org.ninjaneers.motager.dashboard.presentation.collections.presentation

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class CollectionsViewModel : ViewModel() {
    private val _state = MutableStateFlow(CollectionsScreenState())
    val state = _state.asStateFlow()

    fun onAction(action: CollectionsAction) {
        when (action) {
            is CollectionsAction.OnSearchLimitChange -> onSearchLimitChange(action.limit)
            is CollectionsAction.OnSearchQueryChange -> onSearchQueryChange(action.query)
        }
    }

    private fun onSearchLimitChange(limit: Int) {

    }

    private fun onSearchQueryChange(query: String) {

    }
}