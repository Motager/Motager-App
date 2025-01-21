package org.ninjaneers.motager.collections.presentation

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class CollectionsViewModel : ViewModel() {
    private val _state = MutableStateFlow(CollectionsScreenState())
    val state = _state.asStateFlow()

    fun onAction(action: CollectionsActions) {
        when (action) {
            is CollectionsActions.OnSearchLimitChange -> OnSearchLimitChange(action.limit)
            is CollectionsActions.OnSearchQueryChange -> OnSearchQueryChange(action.query)
        }
    }

    private fun OnSearchLimitChange(limit: Int) {

    }

    private fun OnSearchQueryChange(query: String) {

    }
}