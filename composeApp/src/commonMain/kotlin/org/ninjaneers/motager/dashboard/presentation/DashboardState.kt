package org.ninjaneers.motager.dashboard.presentation

import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import motager.composeapp.generated.resources.Analytics
import motager.composeapp.generated.resources.Categories
import motager.composeapp.generated.resources.Collections
import motager.composeapp.generated.resources.Customers
import motager.composeapp.generated.resources.Discounts
import motager.composeapp.generated.resources.Home
import motager.composeapp.generated.resources.Orders
import motager.composeapp.generated.resources.Products
import motager.composeapp.generated.resources.Res
import motager.composeapp.generated.resources.Settings
import motager.composeapp.generated.resources.boxes
import motager.composeapp.generated.resources.chart
import motager.composeapp.generated.resources.customers
import motager.composeapp.generated.resources.discounts
import motager.composeapp.generated.resources.grid_plus
import motager.composeapp.generated.resources.home
import motager.composeapp.generated.resources.orders
import motager.composeapp.generated.resources.products
import motager.composeapp.generated.resources.settings
import org.ninjaneers.motager.app.navigation.Route
import org.ninjaneers.motager.dashboard.domain.NavDrawerItem

data class DashboardState(
    val drawerState: DrawerState = DrawerState(DrawerValue.Closed),
    val navigationItems: List<NavDrawerItem> = listOf(
        NavDrawerItem(
            label = Res.string.Home,
            selected = true,
            icon = Res.drawable.home,
            route = Route.Home
        ),
        NavDrawerItem(
            label = Res.string.Orders,
            selected = false,
            icon = Res.drawable.orders,
            route = Route.Orders
        ),
        NavDrawerItem(
            label = Res.string.Products,
            selected = false,
            icon = Res.drawable.products,
            route = Route.Products
        ),
        NavDrawerItem(
            label = Res.string.Collections,
            selected = false,
            icon = Res.drawable.grid_plus,
            route = Route.Collections
        ),
        NavDrawerItem(
            label = Res.string.Categories,
            selected = false,
            icon = Res.drawable.boxes,
            route = Route.Categories
        ),
        NavDrawerItem(
            label = Res.string.Customers,
            selected = false,
            icon = Res.drawable.customers,
            route = Route.Customers
        ),
        NavDrawerItem(
            label = Res.string.Analytics,
            selected = false,
            icon = Res.drawable.chart,
            route = Route.Analytics
        ),
        NavDrawerItem(
            label = Res.string.Discounts,
            selected = false,
            icon = Res.drawable.discounts,
            route = Route.Discounts
        ),
        NavDrawerItem(
            label = Res.string.Settings,
            selected = false,
            icon = Res.drawable.settings,
            route = Route.Settings
        )
    )
)