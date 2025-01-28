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
    val customerList: List<Customer> = (1..20).map {
        Customer(
            name = "john Doe",
            email = "m@example.com",
            status = "New",
            amountPaid = 100,
        )
    },
    val tableHeaders: List<StringResource> = listOf(
        Res.string.Name,
        Res.string.Email,
        Res.string.AmountPaid,
        Res.string.Status,
        Res.string.Actions
    ),
    val customerNumber: Int = customerList.size
)