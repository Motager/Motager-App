package org.ninjaneers.motager.orders.presentation

import org.ninjaneers.motager.orders.domain.Order

data class OrdersScreenState(
    val searchQuery: String = "",
    val searchLimit: Int = 10,
    val tableHeaders: List<String> = listOf(
        "Order Number",
        "Customer",
        "Total",
        "Status",
        "Actions"
    ),
    val ordersList: List<Order> = (1..20).map { Order() },
    val ordersNumber: Int = ordersList.size
)