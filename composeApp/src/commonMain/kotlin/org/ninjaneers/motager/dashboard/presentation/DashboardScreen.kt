package org.ninjaneers.motager.dashboard.presentation

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
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
import org.ninjaneers.motager.dashboard.presentation.orders.presentation.OrdersScreen
import org.ninjaneers.motager.dashboard.presentation.products.presentation.ProductsScreen
import org.ninjaneers.motager.dashboard.presentation.settings.presentations.SettingsScreen

@Composable
fun DashboardScreen(
    state: DashboardState,
    coreState: CoreState,
    onAction: suspend (DashboardAction) -> Unit,
    coreAction: (CoreAction) -> Unit,
    navigator: Navigator
) {
    DashboardScreenContent(
        state = state,
        coreState = coreState,
        onAction = onAction,
        coreAction = coreAction,
        navigator = navigator,

        )
}

@Composable
private fun DashboardScreenContent(
    state: DashboardState,
    coreState: CoreState,
    onAction: suspend (DashboardAction) -> Unit,
    coreAction: (CoreAction) -> Unit,
    navigator: Navigator
) {
    ModalNavigationDrawer(
        drawerContent = {
            NavDrawer(
                navigationItems = state.navigationItems,
                onAction = onAction,
                coreAction = coreAction
            )
        },
        drawerState = state.drawerState,
        scrimColor = MaterialTheme.colorScheme.background.copy(alpha = 0.5f)
    ) {
        Scaffold(
            topBar = {
                TopBar(
                    openNavDrawer = { onAction(DashboardAction.OpenNavigationDrawer) },
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
                    targetState = state.content,
                    transitionSpec = {
                        slideInVertically(
                            animationSpec = spring(
                                dampingRatio = Spring.DampingRatioMediumBouncy,
                                stiffness = Spring.StiffnessLow
                            )
                        ).togetherWith(slideOutVertically(animationSpec = tween(150)))
                    }
                ) {
                    when (state.content) {
                        is DashboardContent.Home -> HomeScreen(
                            dashboardState = state,
                            coreState = coreState,
                            dashboardAction = onAction,
                            coreAction = coreAction
                        )

                        is DashboardContent.Orders -> OrdersScreen(
                            dashboardState = state,
                            coreState = coreState,
                            dashboardAction = onAction,
                            coreAction = coreAction
                        )

                        is DashboardContent.Products -> ProductsScreen(
                            dashboardState = state,
                            coreState = coreState,
                            dashboardAction = onAction,
                            coreAction = coreAction
                        )

                        is DashboardContent.Collections -> CollectionsScreen(
                            dashboardState = state,
                            coreState = coreState,
                            dashboardAction = onAction,
                            coreAction = coreAction
                        )

                        is DashboardContent.Categories -> CategoriesScreen(
                            dashboardState = state,
                            coreState = coreState,
                            dashboardAction = onAction,
                            coreAction = coreAction
                        )

                        is DashboardContent.Customers -> CustomersScreen(
                            dashboardState = state,
                            coreState = coreState,
                            dashboardAction = onAction,
                            coreAction = coreAction
                        )

                        is DashboardContent.Analytics -> AnalyticsScreen(
                            dashboardState = state,
                            coreState = coreState,
                            dashboardAction = onAction,
                            coreAction = coreAction
                        )

                        is DashboardContent.Discounts -> DiscountsScreen(
                            dashboardState = state,
                            coreState = coreState,
                            dashboardAction = onAction,
                            coreAction = coreAction
                        )

                        is DashboardContent.Settings -> SettingsScreen(
                            dashboardState = state,
                            coreState = coreState,
                            dashboardAction = onAction,
                            coreAction = coreAction
                        )
                    }
                }
            }
        }
    }
}
