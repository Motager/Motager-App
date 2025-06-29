package org.ninjaneers.motager.dashboard.presentation.products.data.dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GenerateDescriptionDTO(
    @SerialName("description")
    val description: String?,
    @SerialName("product_name")
    val productName: String?,
    @SerialName("success")
    val success: Boolean?,
)