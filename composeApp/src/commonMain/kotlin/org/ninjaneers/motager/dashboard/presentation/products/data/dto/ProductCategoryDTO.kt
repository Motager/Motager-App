package org.ninjaneers.motager.dashboard.presentation.products.data.dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ProductCategoryDTO(
    @SerialName("id")
    val id: Int?,
    @SerialName("slug")
    val slug: String?
)