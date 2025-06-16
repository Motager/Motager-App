package org.ninjaneers.motager.dashboard.presentation.customers.data.dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CustomerPostResponseDTO(
    @SerialName("custom_id")
    val customId: Int?,
    @SerialName("customer_email")
    val customerEmail: String?,
)