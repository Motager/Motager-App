package org.ninjaneers.motager.dashboard.presentation.collections.data.dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CollectionPostDTO(
    @SerialName("description")
    val description: String?,
    @SerialName("image_url")
    val imageUrl: String? = null,
    @SerialName("name")
    val name: String?
)