package org.ninjaneers.motager.dashboard.presentation.orders.domain

data class Order(
    val orderNumber: String,
    val customer: String,
    val total: Double,
    val status: String,
)