package org.ninjaneers.motager.dashboard.presentation.orders.data.dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class OrdersResponseDTO(
    @SerialName("orders")
    val orders: List<OrderDTO>?
)