package org.ninjaneers.motager.dashboard.presentation.collections.data.dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CollectionDTO(
    @SerialName("id")
    val id: Int?,
    @SerialName("store_id")
    val storeID: Int?,
    @SerialName("name")
    val name: String?,
    @SerialName("description")
    val description: String?,
)