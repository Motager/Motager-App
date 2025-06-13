package org.ninjaneers.motager.dashboard.presentation.products.data.mappers

import org.ninjaneers.motager.dashboard.presentation.products.data.dto.ProductDTO
import org.ninjaneers.motager.dashboard.presentation.products.domain.Product

fun ProductDTO.toProduct(): Product {
    return Product(
        id = this.id!!,
        name = this.name ?: "",
        description = this.description ?: "",
        image = this.mainImageUrl ?: "",
        price = this.startPrice ?: 0.0,
        isPublished = this.published ?: false,
        category = this.category.slug ?: ""
    )
}