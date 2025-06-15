package org.ninjaneers.motager.dashboard.presentation.products.domain

import org.ninjaneers.motager.dashboard.presentation.categories.domain.Category

data class PostProduct(
    val name: String = "",
    val description: String = "",
    val isPublished: Boolean = false,
    val startPrice: String = "",
    val mainImageUrl: String = "",
    val imagesUrls: List<String> = emptyList(),
    val category: Category,
    val skus: List<SKU> = emptyList(),
)