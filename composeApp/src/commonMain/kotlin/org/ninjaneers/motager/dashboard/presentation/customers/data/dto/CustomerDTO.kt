package org.ninjaneers.motager.dashboard.presentation.customers.data.dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CustomerDTO(
    @SerialName("custom_id")
    val customId: Int?,
    @SerialName("customer_email")
    val customerEmail: String?,
    @SerialName("number_of_orders")
    val numberOfOrders: Int?,
    @SerialName("total_spent")
    val totalSpent: Int?
)