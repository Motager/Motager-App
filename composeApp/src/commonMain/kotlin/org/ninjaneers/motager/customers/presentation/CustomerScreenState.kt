package org.ninjaneers.motager.customers.presentation

import org.ninjaneers.motager.customers.domain.Customer

data class CustomerScreenState(
    val searchQuery: String = "",
    val searchLimit: Int = 10,
    val CustomerList: List<Customer> = (1..20).map {
        Customer(
            Name = "john Doe",
            Email = "m@example.com",
            Status = "New",
            AmountPaid = 100,
        )
    },
    val tapleHeaders: List<String> = listOf("Name", "Email", "Amount Paid", "Status", "Actions"),
    val CustomerNumber: Int = CustomerList.size
)