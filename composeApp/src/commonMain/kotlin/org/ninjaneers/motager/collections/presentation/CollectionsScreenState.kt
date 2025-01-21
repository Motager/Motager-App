package org.ninjaneers.motager.collections.presentation

import org.ninjaneers.motager.collections.domain.Collection

data class CollectionsScreenState(
    val searchQuery: String = "",
    val searchLimit: Int = 10,
    val collectionsList: List<Collection> = emptyList(),
    val collectionsNumber: Int = collectionsList.size
)