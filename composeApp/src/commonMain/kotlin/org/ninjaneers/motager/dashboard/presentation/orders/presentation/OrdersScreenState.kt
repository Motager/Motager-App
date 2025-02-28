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
    val ordersList: List<Order> = listOf(
        Order(
            orderNumber = "ORD001",
            customer = "Jhon Doe",
            total = 150.5,
            status = "Completed"
        ),
        Order(
            orderNumber = "ORD001",
            customer = "Jhon Doe",
            total = 150.5,
            status = "Completed"
        ),
        Order(
            orderNumber = "ORD002",
            customer = "jane smith",
            total = 299.99,
            status = "Pending"
        ), Order(
            orderNumber = "ORD003",
            customer = "Alice Johnson",
            total = 75.0,
            status = "Cancelled"
        ), Order(
            orderNumber = "ORD004",
            customer = "Bob Brown",
            total = 199.9,
            status = "Processing"
        ),
        Order(
            orderNumber = "ORD001",
            customer = "Jhon Doe",
            total = 150.5,
            status = "Completed"
        ),
        Order(
            orderNumber = "ORD001",
            customer = "Jhon Doe",
            total = 150.5,
            status = "Completed"
        ),
        Order(
            orderNumber = "ORD002",
            customer = "jane smith",
            total = 299.99,
            status = "Pending"
        ), Order(
            orderNumber = "ORD003",
            customer = "Alice Johnson",
            total = 75.0,
            status = "Cancelled"
        ), Order(
            orderNumber = "ORD004",
            customer = "Bob Brown",
            total = 199.9,
            status = "Processing"
        )
    ),
    val ordersCount: Int = ordersList.size
)