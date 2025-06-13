package org.ninjaneers.motager.dashboard.presentation.customers.data.dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CustomersResponseDTO(
    @SerialName("customers")
    val customers: List<CustomerDTO>?
)