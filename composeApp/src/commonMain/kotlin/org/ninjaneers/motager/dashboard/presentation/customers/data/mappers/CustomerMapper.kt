package org.ninjaneers.motager.dashboard.presentation.customers.data.mappers

import org.ninjaneers.motager.dashboard.presentation.customers.data.dto.CustomerDTO
import org.ninjaneers.motager.dashboard.presentation.customers.data.dto.CustomerPostResponseDTO
import org.ninjaneers.motager.dashboard.presentation.customers.domain.Customer

fun CustomerDTO.toCustomer(): Customer {
    return Customer(
        id = this.customId ?: 0,
        email = this.customerEmail ?: "",
        totalPayment = this.totalSpent ?: 0.0,
        ordersCount = this.numberOfOrders ?: 0
    )
}

fun CustomerPostResponseDTO.toCustomer(): Customer {
    return Customer(
        id = this.customId ?: 0,
        email = this.customerEmail ?: "",
        totalPayment = 0.0,
        ordersCount = 0
    )
}