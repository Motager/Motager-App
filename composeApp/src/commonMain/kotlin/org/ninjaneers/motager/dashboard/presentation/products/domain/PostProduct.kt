package org.ninjaneers.motager.dashboard.presentation.products.domain

import org.ninjaneers.motager.dashboard.presentation.categories.domain.Category

data class PostProduct(
    val name: String = "",
    val description: String = "",
    val isPublished: Boolean = false,
    val startPrice: String = "",
    val mainImageUrl: String = "",
    val imagesUrls: MutableList<String> = mutableListOf(),
    val category: Category = Category(),
    val skus: List<SKU> = emptyList(),
    val stock: String = "",
    val price: String = "",
    val compareAtPrice: String = "",
    val costPerItem: String = "",
    val profit: String = "",
    val margin: String = "",
    val variants: List<Variant> = emptyList(),
)