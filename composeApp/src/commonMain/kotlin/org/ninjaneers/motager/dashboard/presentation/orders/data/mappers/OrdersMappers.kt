package org.ninjaneers.motager.dashboard.presentation.orders.data.mappers

import org.ninjaneers.motager.dashboard.presentation.orders.data.dto.OrderDTO
import org.ninjaneers.motager.dashboard.presentation.orders.domain.Order

fun OrderDTO.toOrder(): Order {
    return Order(
        customerEmail = this.customerEmail ?: "",
        customerName = this.customerName ?: "",
        totalPrice = this.totalPrice ?: 0.0,
        paymentMethod = this.paymentMethod ?: "",
        city = this.city ?: "",
        shippingMethod = this.shippingMethod ?: "",
        status = this.status?.replaceFirstChar { it.uppercase() } ?: ""
    )
}