package org.ninjaneers.motager.dashboard.presentation.collections.data.dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CollectionsResponseDTO(
    @SerialName("collections")
    val collections: List<CollectionDTO>?
)