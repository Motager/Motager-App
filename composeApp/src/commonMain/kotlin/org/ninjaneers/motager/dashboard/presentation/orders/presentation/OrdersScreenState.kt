package org.ninjaneers.motager.dashboard.presentation.orders.presentation

import motager.composeapp.generated.resources.Actions
import motager.composeapp.generated.resources.Customer
import motager.composeapp.generated.resources.OrderNumber
import motager.composeapp.generated.resources.Res
import motager.composeapp.generated.resources.Status
import motager.composeapp.generated.resources.Total
import org.jetbrains.compose.resources.StringResource
import org.ninjaneers.motager.dashboard.presentation.orders.domain.Order

data class OrdersScreenState(
    val searchQuery: String = "",
    val searchLimit: Int = 10,
    val tableHeaders: List<StringResource> = listOf(
        Res.string.OrderNumber,
        Res.string.Customer,
        Res.string.Total,
        Res.string.Status,
        Res.string.Actions
    ),
    val ordersList: List<Order> = (1..20).map { Order() },
    val ordersCount: Int = ordersList.size
)