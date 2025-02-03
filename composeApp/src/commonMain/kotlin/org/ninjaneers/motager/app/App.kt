package org.ninjaneers.motager.app

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.viewmodel.koinViewModel
import org.ninjaneers.motager.app.navigation.Navigator
import org.ninjaneers.motager.app.navigation.Route
import org.ninjaneers.motager.authentication.presentation.login.LoginScreen
import org.ninjaneers.motager.authentication.presentation.signup.SignupScreen
import org.ninjaneers.motager.core.presentation.koinSharedViewModel
import org.ninjaneers.motager.core.presentation.theme.MotagerTheme
import org.ninjaneers.motager.dashboard.presentation.DashboardViewModel
import org.ninjaneers.motager.dashboard.presentation.analytics.presentation.AnalyticsScreen
import org.ninjaneers.motager.dashboard.presentation.analytics.presentation.AnalyticsViewModel
import org.ninjaneers.motager.dashboard.presentation.categories.presentation.CategoriesScreen
import org.ninjaneers.motager.dashboard.presentation.categories.presentation.CategoriesViewModel
import org.ninjaneers.motager.dashboard.presentation.collections.presentation.CollectionsScreen
import org.ninjaneers.motager.dashboard.presentation.collections.presentation.CollectionsViewModel
import org.ninjaneers.motager.dashboard.presentation.customers.presentation.CustomersScreen
import org.ninjaneers.motager.dashboard.presentation.customers.presentation.CustomersViewModel
import org.ninjaneers.motager.dashboard.presentation.discounts.presentation.DiscountsScreen
import org.ninjaneers.motager.dashboard.presentation.discounts.presentation.DiscountsViewModel
import org.ninjaneers.motager.dashboard.presentation.home.presentation.HomeScreen
import org.ninjaneers.motager.dashboard.presentation.home.presentation.HomeViewModel
import org.ninjaneers.motager.dashboard.presentation.orders.presentation.OrdersScreen
import org.ninjaneers.motager.dashboard.presentation.orders.presentation.OrdersViewModel
import org.ninjaneers.motager.dashboard.presentation.products.presentation.ProductsScreen
import org.ninjaneers.motager.dashboard.presentation.products.presentation.ProductsViewModel
import org.ninjaneers.motager.dashboard.presentation.settings.presentations.SettingsScreen
import org.ninjaneers.motager.dashboard.presentation.settings.presentations.SettingsViewModel
import org.ninjaneers.motager.mainscreen.MainScreen

@Composable
@Preview
fun App() {
    MotagerTheme {
        val navController = rememberNavController()
        val navigator = remember { Navigator(navController) }
        NavHost(navController = navController, startDestination = Route.DashboardGraph) {
            composable<Route.MainScreen> {
                MainScreen(navigator = navigator)
            }

            navigation<Route.AuthenticationGraph>(startDestination = Route.Login) {
                composable<Route.Login> {
                    LoginScreen()
                }
                composable<Route.Signup> {
                    SignupScreen()
                }
            }

            navigation<Route.DashboardGraph>(startDestination = Route.Home) {
                composable<Route.Home>() {
                    val dashboardViewModel =
                        it.koinSharedViewModel<DashboardViewModel>(navController = navController)
                    val dashboardState by dashboardViewModel.state.collectAsStateWithLifecycle()
                    val homeViewModel = koinViewModel<HomeViewModel>()
                    HomeScreen(
                        navigator = navigator,
                        dashboardState = dashboardState,
                        onAction = dashboardViewModel::onAction
                    )
                }
                composable<Route.Orders>() {
                    val dashboardViewModel =
                        it.koinSharedViewModel<DashboardViewModel>(navController = navController)
                    val dashboardState by dashboardViewModel.state.collectAsStateWithLifecycle()
                    val ordersViewModel = koinViewModel<OrdersViewModel>()
                    val state by ordersViewModel.state.collectAsStateWithLifecycle()
                    OrdersScreen(
                        state = state,
                        navigator = navigator,
                        dashboardState = dashboardState,
                        onAction = dashboardViewModel::onAction
                    )
                }
                composable<Route.Products>() {
                    val dashboardViewModel =
                        it.koinSharedViewModel<DashboardViewModel>(navController = navController)
                    val dashboardState by dashboardViewModel.state.collectAsStateWithLifecycle()
                    val productsViewModel = koinViewModel<ProductsViewModel>()
                    val state by productsViewModel.state.collectAsStateWithLifecycle()
                    ProductsScreen(
                        state = state,
                        navigator = navigator,
                        dashboardState = dashboardState,
                        onAction = dashboardViewModel::onAction
                    )
                }
                composable<Route.Collections>() {
                    val dashboardViewModel =
                        it.koinSharedViewModel<DashboardViewModel>(navController = navController)
                    val dashboardState by dashboardViewModel.state.collectAsStateWithLifecycle()
                    val collectionsViewModel = koinViewModel<CollectionsViewModel>()
                    val state by collectionsViewModel.state.collectAsStateWithLifecycle()
                    CollectionsScreen(
                        state = state,
                        navigator = navigator,
                        dashboardState = dashboardState,
                        onAction = dashboardViewModel::onAction
                    )
                }
                composable<Route.Categories>() {
                    val dashboardViewModel =
                        it.koinSharedViewModel<DashboardViewModel>(navController = navController)
                    val dashboardState by dashboardViewModel.state.collectAsStateWithLifecycle()
                    val categoriesViewModel = koinViewModel<CategoriesViewModel>()
                    val state by categoriesViewModel.state.collectAsStateWithLifecycle()
                    CategoriesScreen(
                        state = state,
                        navigator = navigator,
                        dashboardState = dashboardState,
                        onAction = dashboardViewModel::onAction
                    )
                }
                composable<Route.Customers>() {
                    val dashboardViewModel =
                        it.koinSharedViewModel<DashboardViewModel>(navController = navController)
                    val dashboardState by dashboardViewModel.state.collectAsStateWithLifecycle()
                    val customersViewModel = koinViewModel<CustomersViewModel>()
                    val state by customersViewModel.state.collectAsStateWithLifecycle()
                    CustomersScreen(
                        state = state,
                        navigator = navigator,
                        dashboardState = dashboardState,
                        onAction = dashboardViewModel::onAction
                    )
                }
                composable<Route.Analytics>() {
                    val dashboardViewModel =
                        it.koinSharedViewModel<DashboardViewModel>(navController = navController)
                    val dashboardState by dashboardViewModel.state.collectAsStateWithLifecycle()
                    val analyticsViewModel = koinViewModel<AnalyticsViewModel>()
                    AnalyticsScreen(
                        navigator = navigator,
                        dashboardState = dashboardState,
                        onAction = dashboardViewModel::onAction
                    )
                }
                composable<Route.Discounts>() {
                    val dashboardViewModel =
                        it.koinSharedViewModel<DashboardViewModel>(navController = navController)
                    val dashboardState by dashboardViewModel.state.collectAsStateWithLifecycle()
                    val discountsViewModel = koinViewModel<DiscountsViewModel>()
                    DiscountsScreen(
                        navigator = navigator,
                        dashboardState = dashboardState,
                        onAction = dashboardViewModel::onAction
                    )
                }
                composable<Route.Settings>() {
                    val dashboardViewModel =
                        it.koinSharedViewModel<DashboardViewModel>(navController = navController)
                    val dashboardState by dashboardViewModel.state.collectAsStateWithLifecycle()
                    val settingsViewModel = koinViewModel<SettingsViewModel>()
                    SettingsScreen(
                        navigator = navigator,
                        dashboardState = dashboardState,
                        onAction = dashboardViewModel::onAction
                    )
                }
            }
        }
    }
}

