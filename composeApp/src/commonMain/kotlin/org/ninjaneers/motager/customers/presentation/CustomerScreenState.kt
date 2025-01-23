package org.ninjaneers.motager.customers.presentation

import org.ninjaneers.motager.customers.domain.Customer

data class CustomerScreenState(
    val searchQuery: String = "",
    val searchLimit: Int = 10,
    val customerList: List<Customer> = (1..20).map {
        Customer(
            name = "john Doe",
            email = "m@example.com",
            status = "New",
            amountPaid = 100,
        )
    },
    val tapleHeaders: List<String> = listOf("Name", "Email", "Amount Paid", "Status", "Actions"),
    val customerNumber: Int = customerList.size
)