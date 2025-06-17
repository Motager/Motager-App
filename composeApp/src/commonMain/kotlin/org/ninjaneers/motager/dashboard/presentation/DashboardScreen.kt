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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.koin.compose.viewmodel.koinViewModel
import org.ninjaneers.motager.core.presentation.CoreAction
import org.ninjaneers.motager.core.presentation.CoreState
import org.ninjaneers.motager.dashboard.domain.DashboardContent
import org.ninjaneers.motager.dashboard.presentation.analytics.presentation.AnalyticsScreen
import org.ninjaneers.motager.dashboard.presentation.categories.presentation.CategoriesScreen
import org.ninjaneers.motager.dashboard.presentation.categories.presentation.CategoriesViewModel
import org.ninjaneers.motager.dashboard.presentation.collections.presentation.CollectionsScreen
import org.ninjaneers.motager.dashboard.presentation.collections.presentation.CollectionsViewModel
import org.ninjaneers.motager.dashboard.presentation.components.NavDrawer
import org.ninjaneers.motager.dashboard.presentation.components.TopBar
import org.ninjaneers.motager.dashboard.presentation.customers.presentation.CustomersScreen
import org.ninjaneers.motager.dashboard.presentation.customers.presentation.CustomersViewModel
import org.ninjaneers.motager.dashboard.presentation.discounts.presentation.DiscountsScreen
import org.ninjaneers.motager.dashboard.presentation.home.presentation.HomeScreen
import org.ninjaneers.motager.dashboard.presentation.home.presentation.HomeViewModel
import org.ninjaneers.motager.dashboard.presentation.orders.presentation.OrdersScreen
import org.ninjaneers.motager.dashboard.presentation.orders.presentation.OrdersViewModel
import org.ninjaneers.motager.dashboard.presentation.products.presentation.ProductsScreen
import org.ninjaneers.motager.dashboard.presentation.products.presentation.ProductsViewModel
import org.ninjaneers.motager.dashboard.presentation.products.presentation.addproduct.AddProductScreen
import org.ninjaneers.motager.dashboard.presentation.products.presentation.addproduct.AddProductViewModel

@Composable
fun DashboardScreen(
    dashboardState: DashboardState,
    coreState: CoreState,
    dashboardAction: suspend (DashboardAction) -> Unit,
    coreAction: (CoreAction) -> Unit,
    onLogout: () -> Unit,
) {
    DashboardScreenContent(
        dashboardState = dashboardState,
        coreState = coreState,
        dashboardAction = dashboardAction,
        coreAction = coreAction,
        onLogout = onLogout
    )
}

@Composable
private fun DashboardScreenContent(
    dashboardState: DashboardState,
    coreState: CoreState,
    dashboardAction: suspend (DashboardAction) -> Unit,
    coreAction: (CoreAction) -> Unit,
    onLogout: () -> Unit,
) {
    LaunchedEffect(Unit) {
        coreAction(CoreAction.OnStoreChange(coreState.user?.stores!!.first()!!))
    }
    ModalNavigationDrawer(
        drawerContent = {
            NavDrawer(
                state = dashboardState,
                coreState = coreState,
                onAction = dashboardAction,
                coreAction = coreAction,
                items = dashboardState.navigationItems,
            )
        },
        drawerState = dashboardState.drawerState,
        scrimColor = MaterialTheme.colorScheme.background.copy(alpha = 0.5f)
    ) {
        Scaffold(
            topBar = {
                TopBar(
                    onAction = dashboardAction,
                    dashboardState = dashboardState,
                    coreState = coreState,
                    onLogout = {
                        onLogout()
                    }
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

                        is DashboardContent.Orders -> {
                            val viewModel = koinViewModel<OrdersViewModel>()
                            val state by viewModel.state.collectAsStateWithLifecycle()
                            OrdersScreen(
                                state = state,
                                coreState = coreState,
                                onAction = viewModel::onAction
                            )
                        }

                        is DashboardContent.Products -> {
                            val viewModel = koinViewModel<ProductsViewModel>()
                            val state by viewModel.state.collectAsStateWithLifecycle()
                            ProductsScreen(
                                state = state,
                                coreState = coreState,
                                onAction = viewModel::onAction,
                                dashboardAction = dashboardAction
                            )
                        }

                        is DashboardContent.Collections -> {
                            val viewModel = koinViewModel<CollectionsViewModel>()
                            val state by viewModel.state.collectAsStateWithLifecycle()
                            CollectionsScreen(
                                state = state,
                                coreState = coreState,
                                onAction = viewModel::onAction,
                            )
                        }

                        is DashboardContent.Categories -> {
                            val viewModel = koinViewModel<CategoriesViewModel>()
                            val state by viewModel.state.collectAsStateWithLifecycle()
                            CategoriesScreen(
                                state = state,
                                coreState = coreState,
                                onAction = viewModel::onAction,
                            )
                        }

                        is DashboardContent.Customers -> {
                            val viewModel = koinViewModel<CustomersViewModel>()
                            val state by viewModel.state.collectAsStateWithLifecycle()
                            CustomersScreen(
                                state = state,
                                coreState = coreState,
                                onAction = viewModel::onAction,
                            )
                        }

                        is DashboardContent.Analytics -> {

                            AnalyticsScreen(
                                coreState = coreState,
                            )
                        }

                        is DashboardContent.Discounts -> {
                            DiscountsScreen(
                                coreState = coreState,
                            )
                        }


                        DashboardContent.AddProduct -> {
                            val viewModel = koinViewModel<AddProductViewModel>()
                            val state by viewModel.state.collectAsStateWithLifecycle()
                            AddProductScreen(
                                state = state,
                                coreState = coreState,
                                onAction = viewModel::onAction,
                                dashboardAction = dashboardAction,
                            )
                        }
                    }
                }
            }
        }
    }
}
