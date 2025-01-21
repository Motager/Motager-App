package org.ninjaneers.motager.products.domain

data class Product(
    val image: String = "",
    val name: String = "",
    val price: Double = 0.0,
    val category: String = "",
)