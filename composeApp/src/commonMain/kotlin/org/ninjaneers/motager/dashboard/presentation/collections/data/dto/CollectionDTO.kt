package org.ninjaneers.motager.dashboard.presentation.collections.data.dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CollectionDTO(
    @SerialName("id")
    val id: Int?,
    @SerialName("name")
    val name: String?,
)