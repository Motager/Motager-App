package org.ninjaneers.motager.dashboard.presentation.collections.presentation

import motager.composeapp.generated.resources.Actions
import motager.composeapp.generated.resources.Name
import motager.composeapp.generated.resources.Products
import motager.composeapp.generated.resources.Res
import org.jetbrains.compose.resources.StringResource
import org.ninjaneers.motager.core.domain.UiText
import org.ninjaneers.motager.dashboard.presentation.collections.domain.Collection

data class CollectionsState(
    val isLoading: Boolean = false,
    val isError: UiText? = null,
    val searchQuery: String = "",
    val searchLimit: Int = 10,
    val collectionsList: List<Collection> = emptyList(),
    val tableHeaders: List<StringResource> = listOf(
        Res.string.Name,
        Res.string.Products,
        Res.string.Actions
    )
)