package org.ninjaneers.motager.dashboard.presentation.customers.domain

data class Customer(
    val name: String,
    val email: String,
    val amountPaid: Int,
    val status: String
)