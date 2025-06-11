package org.ninjaneers.motager.dashboard.presentation.orders.presentation

import motager.composeapp.generated.resources.Actions
import motager.composeapp.generated.resources.City
import motager.composeapp.generated.resources.Customer_Email
import motager.composeapp.generated.resources.Customer_Name
import motager.composeapp.generated.resources.Payment_Method
import motager.composeapp.generated.resources.Res
import motager.composeapp.generated.resources.Shipping_Method
import motager.composeapp.generated.resources.Status
import motager.composeapp.generated.resources.Total_Price
import org.jetbrains.compose.resources.StringResource
import org.ninjaneers.motager.core.domain.UiText
import org.ninjaneers.motager.dashboard.presentation.orders.domain.Order

data class OrdersScreenState(
    val isLoading: Boolean = false,
    val isError: UiText? = null,
    val searchQuery: String = "",
    val searchLimit: Int = 10,
    val orders: List<Order> = emptyList(),
    val tableHeaders: List<StringResource> = listOf(
        Res.string.Customer_Email,
        Res.string.Customer_Name,
        Res.string.Total_Price,
        Res.string.Payment_Method,
        Res.string.City,
        Res.string.Shipping_Method,
        Res.string.Status,
        Res.string.Actions,
    )
)