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
    val collectionsList: List<Collection> = listOf(
        Collection(
            name = "Collection 1",
            productsNumber = 10
        ),
        Collection(
            name = "Collection 2",
            productsNumber = 15
        ),
        Collection(
            name = "Collection 3",
            productsNumber = 7
        ),
        Collection(
            name = "Collection 1",
            productsNumber = 10
        ),
        Collection(
            name = "Collection 2",
            productsNumber = 15
        ),
        Collection(
            name = "Collection 3",
            productsNumber = 7
        )
    ),
    val tableHeaders: List<StringResource> = listOf(
        Res.string.Name,
        Res.string.Products,
        Res.string.Actions
    ),
    val collectionsCount: Int = collectionsList.size
)