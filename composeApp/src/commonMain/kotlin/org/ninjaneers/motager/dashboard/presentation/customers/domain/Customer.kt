package org.ninjaneers.motager.dashboard.presentation.customers.domain

data class Customer(
    val id: Int,
    val email: String,
    val totalPayment: Double,
    val ordersCount: Int
)