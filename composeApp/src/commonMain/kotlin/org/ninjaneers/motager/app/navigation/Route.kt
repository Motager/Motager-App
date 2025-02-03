package org.ninjaneers.motager.app.navigation

import kotlinx.serialization.Serializable

sealed interface Route {

    @Serializable
    data object MainScreen : Route

    @Serializable
    data object AuthenticationGraph : Route

    @Serializable
    data object Login : Route

    @Serializable
    data object Signup : Route

    @Serializable
    data object DashboardGraph : Route

    @Serializable
    data object Home : Route

    @Serializable
    data object Orders : Route

    @Serializable
    data object Products : Route

    @Serializable
    data object Collections : Route

    @Serializable
    data object Categories : Route

    @Serializable
    data object Customers : Route

    @Serializable
    data object Analytics : Route

    @Serializable
    data object Discounts : Route

    @Serializable
    data object Settings : Route


}