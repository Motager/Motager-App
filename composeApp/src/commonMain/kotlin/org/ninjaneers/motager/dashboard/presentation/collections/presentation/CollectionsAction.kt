package org.ninjaneers.motager.dashboard.presentation.collections.presentation

sealed interface CollectionsAction {
    data class OnSearchQueryChange(val query: String) : CollectionsAction
    data class OnSearchLimitChange(val limit: Int) : CollectionsAction
    data class OnCollectionsGet(val storeID: Int) : CollectionsAction
}