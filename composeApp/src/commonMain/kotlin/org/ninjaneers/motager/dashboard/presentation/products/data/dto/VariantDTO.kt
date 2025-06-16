package org.ninjaneers.motager.dashboard.presentation.products.data.dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class VariantDTO(
    @SerialName("name")
    val name: String?,
    @SerialName("value")
    val value: String?,
)