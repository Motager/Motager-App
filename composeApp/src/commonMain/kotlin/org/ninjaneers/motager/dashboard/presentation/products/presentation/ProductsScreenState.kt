package org.ninjaneers.motager.dashboard.presentation.products.presentation

import motager.composeapp.generated.resources.Actions
import motager.composeapp.generated.resources.Category
import motager.composeapp.generated.resources.Image
import motager.composeapp.generated.resources.Name
import motager.composeapp.generated.resources.Price
import motager.composeapp.generated.resources.Res
import org.jetbrains.compose.resources.StringResource
import org.ninjaneers.motager.dashboard.presentation.products.domain.Product

data class ProductsScreenState(
    val searchQuery: String = "",
    val searchLimit: Int = 10,
    val productsList: List<Product> = (1..20).map {
        Product(
            name = "Bluetooth Speaker",
            price = 200.50,
            category = "Electronics"
        )
    },
    val tableHeaders: List<StringResource> = listOf(
        Res.string.Image,
        Res.string.Name,
        Res.string.Price,
        Res.string.Category,
        Res.string.Actions
    ),
    val productsCount: Int = productsList.size
)