package org.ninjaneers.motager.dashboard.presentation.products.presentation

import motager.composeapp.generated.resources.Actions
import motager.composeapp.generated.resources.Category
import motager.composeapp.generated.resources.Description
import motager.composeapp.generated.resources.Image
import motager.composeapp.generated.resources.Name
import motager.composeapp.generated.resources.Price
import motager.composeapp.generated.resources.Res
import org.jetbrains.compose.resources.StringResource
import org.ninjaneers.motager.core.domain.UiText
import org.ninjaneers.motager.dashboard.presentation.products.domain.Product

data class ProductsState(
    val isLoading: Boolean = false,
    val isError: UiText? = null,
    val searchQuery: String = "",
    val searchLimit: Int = 10,
    val products: List<Product> = emptyList(),
    val tableHeaders: List<StringResource> = listOf(
        Res.string.Image,
        Res.string.Name,
        Res.string.Description,
        Res.string.Category,
        Res.string.Price,
        Res.string.Actions
    ),
)