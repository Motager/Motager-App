package org.ninjaneers.motager.dashboard.presentation.products.data.mappers

import org.ninjaneers.motager.dashboard.presentation.products.data.dto.GenerateDescriptionDTO
import org.ninjaneers.motager.dashboard.presentation.products.domain.GeneratedDescription

fun GenerateDescriptionDTO.toGeneratedDescription(): GeneratedDescription {
    return GeneratedDescription(
        productName = this.productName ?: "",
        description = this.description ?: ""
    )
}