package org.ninjaneers.motager.dashboard.presentation.products.domain

data class Product(
    val id: Int = 0,
    val image: String = "",
    val name: String = "",
    val description: String = "",
    val price: Double = 0.0,
    val isPublished: Boolean = false,
    val category: String = ""
)