package org.ninjaneers.motager.dashboard.presentation.customers.presentation

import motager.composeapp.generated.resources.Actions
import motager.composeapp.generated.resources.Email
import motager.composeapp.generated.resources.Res
import motager.composeapp.generated.resources.TotalSpent
import org.jetbrains.compose.resources.StringResource
import org.ninjaneers.motager.core.domain.UiText
import org.ninjaneers.motager.dashboard.presentation.customers.domain.Customer

data class CustomerScreenState(
    val isLoading: Boolean = false,
    val isError: UiText? = null,
    val searchQuery: String = "",
    val searchLimit: Int = 10,
    val customers: List<Customer> = emptyList(),
    val tableHeaders: List<StringResource> = listOf(
        Res.string.Email,
        Res.string.TotalSpent,
        Res.string.Actions
    ),
    val customerEmail: String = "",
    val isCustomerDialogVisible: Boolean = false,
    val isAddCustomerLoading: Boolean = false,
    val isAddCustomerError: UiText? = null,
)