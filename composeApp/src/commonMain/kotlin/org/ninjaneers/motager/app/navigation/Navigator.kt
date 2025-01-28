package org.ninjaneers.motager.app.navigation

import androidx.navigation.NavController

class Navigator(private val navController: NavController) {
    fun navigate(route: Route) {
        when (route) {
            Route.MainScreen -> navController.navigate(Route.MainScreen)

            Route.Login -> navController.navigate(Route.Login)

            Route.Signup -> navController.navigate(Route.Signup)

            Route.Products -> navController.navigate(Route.Products) {
                popUpTo(Route.Products)
            }

            Route.Categories -> navController.navigate(Route.Categories) {
                popUpTo(Route.Categories)
            }

            Route.Collections -> navController.navigate(Route.Collections) {
                popUpTo(Route.Collections)
            }

            Route.Customers -> navController.navigate(Route.Customers) {
                popUpTo(Route.Customers)
            }

            Route.Orders -> navController.navigate(Route.Orders) {
                popUpTo(Route.Orders)
            }

            Route.Analytics -> navController.navigate(Route.Analytics) {
                popUpTo(Route.Analytics)
            }

            Route.Discounts -> navController.navigate(Route.Discounts) {
                popUpTo(Route.Discounts)
            }

            Route.Home -> navController.navigate(Route.Home) {
                popUpTo(Route.Home)
            }

            Route.Settings -> navController.navigate(Route.Settings) {
                popUpTo(Route.Settings)
            }
        }
    }
}