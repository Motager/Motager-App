package org.ninjaneers.motager.app.navigation

import kotlinx.serialization.Serializable

sealed interface Route {

    @Serializable
    data object MotagerGraph : Route

    @Serializable
    data object MainScreen : Route

    @Serializable
    data object Splash : Route

    @Serializable
    data object AuthenticationGraph : Route

    @Serializable
    data object Login : Route

    @Serializable
    data object DashboardGraph : Route

    @Serializable
    data object Dashboard : Route

}