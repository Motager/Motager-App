package org.ninjaneers.motager.orders.presentation

import org.ninjaneers.motager.orders.domain.Order

data class OrderScreenState(
    val searchQuery: String = "",
    val searchLimit: Int = 10,
    val ordersList: List<Order> = (1..20).map { Order() },
    val resultNumber: Int = ordersList.size
)