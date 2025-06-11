package org.ninjaneers.motager.dashboard.presentation.categories.data.dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CategoriesResponseDTO(
    @SerialName("categories")
    val categories: List<CategoryDTO>?
)