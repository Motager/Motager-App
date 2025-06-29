package org.ninjaneers.motager.dashboard.presentation.orders.domain

data class Order(
    val customerEmail: String,
    val customerName: String,
    val totalPrice: Double,
    val paymentMethod: String,
    val city: String,
    val shippingMethod: String,
    val status: String
)