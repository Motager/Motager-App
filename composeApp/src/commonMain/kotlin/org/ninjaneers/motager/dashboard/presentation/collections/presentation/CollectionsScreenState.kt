package org.ninjaneers.motager.dashboard.presentation.collections.presentation

import motager.composeapp.generated.resources.Actions
import motager.composeapp.generated.resources.Name
import motager.composeapp.generated.resources.Products
import motager.composeapp.generated.resources.Res
import org.jetbrains.compose.resources.StringResource
import org.ninjaneers.motager.dashboard.presentation.collections.domain.Collection

data class CollectionsScreenState(
    val searchQuery: String = "",
    val searchLimit: Int = 10,
    val collectionsList: List<Collection> = (1..20).map {
        Collection(
            name = "Collection 1",
            productsNumber = 10
        )
    },
    val tableHeaders: List<StringResource> = listOf(
        Res.string.Name,
        Res.string.Products,
        Res.string.Actions
    ),
    val collectionsNumber: Int = collectionsList.size
)