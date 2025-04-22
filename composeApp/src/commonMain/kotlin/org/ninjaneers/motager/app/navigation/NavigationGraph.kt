package org.ninjaneers.motager.app.navigation

import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import org.koin.compose.viewmodel.koinViewModel
import org.ninjaneers.motager.authentication.presentation.login.presentation.LoginScreen
import org.ninjaneers.motager.authentication.presentation.login.presentation.LoginViewModel
import org.ninjaneers.motager.authentication.presentation.signup.presentation.SignupScreen
import org.ninjaneers.motager.authentication.presentation.signup.presentation.SignupViewModel
import org.ninjaneers.motager.core.presentation.CoreAction
import org.ninjaneers.motager.core.presentation.CoreState
import org.ninjaneers.motager.core.presentation.SplashScreen
import org.ninjaneers.motager.dashboard.presentation.DashboardScreen
import org.ninjaneers.motager.dashboard.presentation.DashboardViewModel
import org.ninjaneers.motager.mainscreen.MainScreen

@Composable
fun NavigationGraph(
    coreState: CoreState,
    coreAction: (CoreAction) -> Unit
) {
    val navController = rememberNavController()
    val navigator = remember { Navigator(navController) }
    NavHost(navController = navController, startDestination = Route.MotagerGraph) {

        navigation<Route.MotagerGraph>(startDestination = Route.Splash) {

            composable<Route.Splash>(
                exitTransition = {
                    fadeOut(animationSpec = tween(750), targetAlpha = 0.9f)
                }
            ) {
                SplashScreen(
                    theme = coreState.theme,
                    language = coreState.language,
                    navigate = {
                        navController.navigate(Route.MainScreen) {
                            popUpTo<Route.Splash> {
                                inclusive = true
                            }
                        }
                    })
            }

            composable<Route.MainScreen> {
                MainScreen(
                    coreState = coreState,
                    navigator = navigator
                )
            }

            navigation<Route.AuthenticationGraph>(
                startDestination = Route.Login,
                enterTransition = { fadeIn(animationSpec = tween(750)) }
            ) {
                composable<Route.Login> {
                    val viewModel = koinViewModel<LoginViewModel>()
                    val state by viewModel.state.collectAsStateWithLifecycle()
                    LoginScreen(
                        state = state,
                        coreState = coreState,
                        onAction = viewModel::onAction,
                        coreAction = coreAction,
                        goToSignup = { navController.navigate(Route.Signup) },
                        goToDashboard = { navController.navigate(Route.DashboardGraph) },
                    )
                }
                composable<Route.Signup> {
                    val viewModel = koinViewModel<SignupViewModel>()
                    val state by viewModel.state.collectAsStateWithLifecycle()
                    SignupScreen(
                        state = state,
                        coreState = coreState,
                        onAction = viewModel::onAction,
                        coreAction = coreAction,
                        backToLogin = { navController.navigate(Route.Login) },
                        goToDashBoard = { navController.navigate(Route.DashboardGraph) },
                    )
                }
            }

            navigation<Route.DashboardGraph>(startDestination = Route.Dashboard) {
                composable<Route.Dashboard> {
                    val viewModel = koinViewModel<DashboardViewModel>()
                    val state by viewModel.state.collectAsStateWithLifecycle()
                    DashboardScreen(
                        dashboardState = state,
                        coreState = coreState,
                        dashboardAction = viewModel::onAction,
                        coreAction = coreAction,
                    )
                }
            }
        }
    }
}