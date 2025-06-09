package org.ninjaneers.motager.dashboard.presentation.collections.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.ninjaneers.motager.core.domain.onError
import org.ninjaneers.motager.core.domain.onSuccess
import org.ninjaneers.motager.core.presentation.toUiText
import org.ninjaneers.motager.dashboard.presentation.collections.domain.CollectionRepository

class CollectionsViewModel(
    private val repository: CollectionRepository
) : ViewModel() {
    private val _state = MutableStateFlow(CollectionsState())
    val state = _state.asStateFlow()


    fun onAction(action: CollectionsAction) {
        when (action) {
            is CollectionsAction.OnSearchLimitChange -> onSearchLimitChange(action.limit)
            is CollectionsAction.OnSearchQueryChange -> onSearchQueryChange(action.query)
            is CollectionsAction.OnCollectionsGet -> onCollectionsGet(action.storeID)
        }
    }

    private fun onCollectionsGet(storeID: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            _state.update {
                it.copy(
                    isLoading = true,
                    isError = null,
                )
            }
            repository.getAllCollectionsInStore(storeID)
                .onSuccess { collections ->
                    _state.update {
                        it.copy(
                            isLoading = false,
                            collectionsList = collections,
                            isError = null
                        )
                    }
                }
                .onError { error ->
                    _state.update {
                        it.copy(
                            isLoading = false,
                            isError = error.toUiText()
                        )
                    }
                }
        }
    }

    private fun onSearchLimitChange(limit: Int) {

    }

    private fun onSearchQueryChange(query: String) {

    }
}