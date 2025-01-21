package org.ninjaneers.motager.collections.presentation

import org.ninjaneers.motager.collections.domain.Collection

data class CollectionsScreenState(
    val searchQuery: String = "",
    val searchLimit: Int = 10,
    val collectionsList: List<Collection> = (1..20).map {
        Collection(
            name = "Collection 1",
            productsNumber = 10
        )
    },
    val tableHeaders: List<String> = listOf("Name", "Products", "Actions"),
    val collectionsNumber: Int = collectionsList.size
)