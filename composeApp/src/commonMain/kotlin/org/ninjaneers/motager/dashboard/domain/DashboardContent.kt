package org.ninjaneers.motager.dashboard.domain


sealed interface DashboardContent {

    data object Home : DashboardContent

    data object Orders : DashboardContent

    data object Products : DashboardContent

    data object AddProduct : DashboardContent

    data object Collections : DashboardContent

    data object Categories : DashboardContent

    data object Customers : DashboardContent

    data object Analytics : DashboardContent

    data object Discounts : DashboardContent

    data object Settings : DashboardContent

}