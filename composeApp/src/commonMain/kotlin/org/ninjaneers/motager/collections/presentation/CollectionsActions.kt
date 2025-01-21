package org.ninjaneers.motager.collections.presentation

sealed interface CollectionsActions {
    data class OnSearchQueryChange(val query: String) : CollectionsActions
    data class OnSearchLimitChange(val limit: Int) : CollectionsActions
}