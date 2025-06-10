package org.ninjaneers.motager.dashboard.presentation.categories.data.mappers

import org.ninjaneers.motager.dashboard.presentation.categories.data.dto.CategoryDTO
import org.ninjaneers.motager.dashboard.presentation.categories.domain.Category

fun CategoryDTO.toCategory(): Category {
    return Category(
        id = this.id ?: 0,
        storeID = this.storeID ?: 0,
        name = this.name ?: "",
        description = this.description ?: ""
    )
}