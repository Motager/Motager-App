package org.ninjaneers.motager.dashboard.presentation.products.domain

data class SKU(
    val stock: String = "",
    val price: String = "",
    val compareAtPrice: String = "",
    val costPerItem: String = "",
    val profit: String = "",
    val margin: String = "",
    val variants: List<Variant> = emptyList(),
)