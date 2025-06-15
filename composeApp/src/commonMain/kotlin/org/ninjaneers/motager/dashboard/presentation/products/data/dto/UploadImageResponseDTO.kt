package org.ninjaneers.motager.dashboard.presentation.products.data.dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UploadImageResponseDTO(
    @SerialName("data")
    val `data`: String?,
    @SerialName("message")
    val message: String?,
    @SerialName("status")
    val status: Boolean?,
)