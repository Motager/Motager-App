package org.ninjaneers.motager.dashboard.presentation.categories.data.dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CategoryPostDTO(
    @SerialName("description")
    val description: String?,
    @SerialName("name")
    val name: String?
)