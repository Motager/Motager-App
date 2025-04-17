package org.ninjaneers.motager.dashboard.presentation

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.koin.compose.viewmodel.koinViewModel
import org.ninjaneers.motager.app.navigation.Navigator
import org.ninjaneers.motager.core.presentation.CoreAction
import org.ninjaneers.motager.core.presentation.CoreState
import org.ninjaneers.motager.dashboard.domain.DashboardContent
import org.ninjaneers.motager.dashboard.presentation.analytics.presentation.AnalyticsScreen
import org.ninjaneers.motager.dashboard.presentation.categories.presentation.CategoriesScreen
import org.ninjaneers.motager.dashboard.presentation.collections.presentation.CollectionsScreen
import org.ninjaneers.motager.dashboard.presentation.components.NavDrawer
import org.ninjaneers.motager.dashboard.presentation.components.TopBar
import org.ninjaneers.motager.dashboard.presentation.customers.presentation.CustomersScreen
import org.ninjaneers.motager.dashboard.presentation.discounts.presentation.DiscountsScreen
import org.ninjaneers.motager.dashboard.presentation.home.presentation.HomeScreen
import org.ninjaneers.motager.dashboard.presentation.home.presentation.HomeViewModel
import org.ninjaneers.motager.dashboard.presentation.orders.presentation.OrdersScreen
import org.ninjaneers.motager.dashboard.presentation.products.presentation.ProductsScreen
import org.ninjaneers.motager.dashboard.presentation.settings.presentations.SettingsScreen

@Composable
fun DashboardScreen(
    dashboardState: DashboardState,
    coreState: CoreState,
    dashboardAction: suspend (DashboardAction) -> Unit,
    coreAction: (CoreAction) -> Unit,
    navigator: Navigator
) {
    DashboardScreenContent(
        dashboardState = dashboardState,
        coreState = coreState,
        dashboardAction = dashboardAction,
        coreAction = coreAction,
        navigator = navigator,
        )
}

@Composable
private fun DashboardScreenContent(
    dashboardState: DashboardState,
    coreState: CoreState,
    dashboardAction: suspend (DashboardAction) -> Unit,
    coreAction: (CoreAction) -> Unit,
    navigator: Navigator
) {
    ModalNavigationDrawer(
        drawerContent = {
            NavDrawer(
                state = dashboardState,
                onAction = dashboardAction,
                coreAction = coreAction,
                items = dashboardState.navigationItems,
                language = coreState.language
            )
        },
        drawerState = dashboardState.drawerState,
        scrimColor = MaterialTheme.colorScheme.background.copy(alpha = 0.5f)
    ) {
        Scaffold(
            topBar = {
                TopBar(
                    openNavDrawer = dashboardAction,
                    coreState = coreState
                )
            }
        ) { innerPadding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colorScheme.background)
                    .padding(innerPadding)
                    .padding(8.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                AnimatedContent(
                    targetState = dashboardState.content,
                    transitionSpec = {
                        slideInVertically(
                            animationSpec = spring(
                                dampingRatio = Spring.DampingRatioLowBouncy,
                                stiffness = Spring.StiffnessLow
                            )
                        ).togetherWith(fadeOut(animationSpec = tween(10)))
                    }
                ) {
                    when (dashboardState.content) {
                        is DashboardContent.Home -> {
                            val viewModel = koinViewModel<HomeViewModel>()
                            val state by viewModel.state.collectAsStateWithLifecycle()
                            HomeScreen(
                                state = state,
                                coreState = coreState,
                                onAction = viewModel::onAction,
                            )
                        }

                        is DashboardContent.Orders -> OrdersScreen(
                            dashboardState = dashboardState,
                            coreState = coreState,
                            dashboardAction = dashboardAction,
                            coreAction = coreAction
                        )

                        is DashboardContent.Products -> ProductsScreen(
                            dashboardState = dashboardState,
                            coreState = coreState,
                            dashboardAction = dashboardAction,
                            coreAction = coreAction
                        )

                        is DashboardContent.Collections -> CollectionsScreen(
                            dashboardState = dashboardState,
                            coreState = coreState,
                            dashboardAction = dashboardAction,
                            coreAction = coreAction
                        )

                        is DashboardContent.Categories -> CategoriesScreen(
                            dashboardState = dashboardState,
                            coreState = coreState,
                            dashboardAction = dashboardAction,
                            coreAction = coreAction
                        )

                        is DashboardContent.Customers -> CustomersScreen(
                            dashboardState = dashboardState,
                            coreState = coreState,
                            dashboardAction = dashboardAction,
                            coreAction = coreAction
                        )

                        is DashboardContent.Analytics -> AnalyticsScreen(
                            dashboardState = dashboardState,
                            coreState = coreState,
                            dashboardAction = dashboardAction,
                            coreAction = coreAction
                        )

                        is DashboardContent.Discounts -> DiscountsScreen(
                            dashboardState = dashboardState,
                            coreState = coreState,
                            dashboardAction = dashboardAction,
                            coreAction = coreAction
                        )

                        is DashboardContent.Settings -> SettingsScreen(
                            dashboardState = dashboardState,
                            coreState = coreState,
                            dashboardAction = dashboardAction,
                            coreAction = coreAction
                        )
                    }
                }
            }
        }
    }
}
