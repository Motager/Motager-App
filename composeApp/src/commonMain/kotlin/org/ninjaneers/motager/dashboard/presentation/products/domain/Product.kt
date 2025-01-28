package org.ninjaneers.motager.dashboard.presentation.products.domain

data class Product(
    val image: String = "",
    val name: String = "",
    val price: Double = 0.0,
    val category: String = "",
)