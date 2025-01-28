package org.ninjaneers.motager.dashboard.presentation.orders.domain

data class Order(
    val orderNumber: String = "ORD001",
    val customer: String = "John Doe",
    val total: Double = 120.05,
    val status: String = "Completed",
)