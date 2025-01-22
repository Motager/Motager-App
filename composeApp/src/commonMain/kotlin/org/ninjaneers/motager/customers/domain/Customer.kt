package org.ninjaneers.motager.customers.domain

data class Customer(
    val Name: String = "John Doe",
    val Email: String = "m@example.com",
    val AmountPaid: Int = 100,
    val Status: String = "New",
    val actions: String = ":",

    )