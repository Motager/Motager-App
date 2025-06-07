package org.ninjaneers.motager.app.navigation

import androidx.navigation.NavController

class Navigator(private val navController: NavController) {
    fun navigate(route: Route) {
        when (route) {
            Route.MainScreen -> navController.navigate(Route.MainScreen)

            Route.Login -> navController.navigate(Route.Login)

            Route.AuthenticationGraph -> {
                navController.navigate(Route.AuthenticationGraph)
            }

            Route.DashboardGraph -> {
                navController.navigate(Route.DashboardGraph)
            }

            Route.Dashboard -> navController.navigate(Route.Dashboard)
            Route.Splash -> {}
            Route.MotagerGraph -> {}
        }
    }
}