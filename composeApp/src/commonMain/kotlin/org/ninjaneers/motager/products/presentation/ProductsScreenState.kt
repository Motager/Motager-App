package org.ninjaneers.motager.products.presentation

import org.ninjaneers.motager.products.domain.Product

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
    val tableHeaders: List<String> = listOf("Image", "Name", "Price", "Category", "Actions"),
    val productsNumber: Int = productsList.size
)