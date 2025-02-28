package org.ninjaneers.motager.dashboard.presentation.customers.presentation

import motager.composeapp.generated.resources.Actions
import motager.composeapp.generated.resources.AmountPaid
import motager.composeapp.generated.resources.Email
import motager.composeapp.generated.resources.Name
import motager.composeapp.generated.resources.Res
import motager.composeapp.generated.resources.Status
import org.jetbrains.compose.resources.StringResource
import org.ninjaneers.motager.dashboard.presentation.customers.domain.Customer

data class CustomerScreenState(
    val searchQuery: String = "",
    val searchLimit: Int = 10,
    val customerList: List<Customer> = listOf(
        Customer(
            name = "john Doe",
            email = "m@example.com",
            status = "New",
            amountPaid = 100,
        ),
        Customer(
            name = "Jane Smith",
            email = "jane@example.com",
            status = "Active",
            amountPaid = 200,
        ),
        Customer(
            name = "Mike Johnson",
            email = "mike@example.com",
            status = "New",
            amountPaid = 50,
        ),
        Customer(
            name = "Emily Davis",
            email = "emily@example.com",
            status = "Premium",
            amountPaid = 300,
        ),
        Customer(
            name = "john Doe",
            email = "m@example.com",
            status = "New",
            amountPaid = 100,
        ),
        Customer(
            name = "Jane Smith",
            email = "jane@example.com",
            status = "Active",
            amountPaid = 200,
        ),
        Customer(
            name = "Mike Johnson",
            email = "mike@example.com",
            status = "New",
            amountPaid = 50,
        ),
        Customer(
            name = "Emily Davis",
            email = "emily@example.com",
            status = "Premium",
            amountPaid = 300,
        ),
        Customer(
            name = "Jane Smith",
            email = "jane@example.com",
            status = "Active",
            amountPaid = 200,
        ),
        Customer(
            name = "Mike Johnson",
            email = "mike@example.com",
            status = "New",
            amountPaid = 50,
        ),
        Customer(
            name = "Emily Davis",
            email = "emily@example.com",
            status = "Premium",
            amountPaid = 300,
        ),
    ),
    val tableHeaders: List<StringResource> = listOf(
        Res.string.Name,
        Res.string.Email,
        Res.string.AmountPaid,
        Res.string.Status,
        Res.string.Actions
    ),
    val customersCount: Int = customerList.size
)