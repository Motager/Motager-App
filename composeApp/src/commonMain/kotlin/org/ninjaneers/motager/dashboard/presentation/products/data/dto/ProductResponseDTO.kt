package org.ninjaneers.motager.dashboard.presentation.products.data.dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ProductResponseDTO(
    @SerialName("products")
    val products: List<ProductDTO>?,
)