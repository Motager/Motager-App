package org.ninjaneers.motager.app

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.LayoutDirection
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.viewmodel.koinViewModel
import org.ninjaneers.motager.app.navigation.Navigator
import org.ninjaneers.motager.app.navigation.Route
import org.ninjaneers.motager.authentication.presentation.login.presentation.LoginScreen
import org.ninjaneers.motager.authentication.presentation.login.presentation.LoginViewModel
import org.ninjaneers.motager.authentication.presentation.signup.presentation.SignupScreen
import org.ninjaneers.motager.authentication.presentation.signup.presentation.SignupViewModel
import org.ninjaneers.motager.core.domain.Language
import org.ninjaneers.motager.core.domain.Theme
import org.ninjaneers.motager.core.presentation.CoreViewModel
import org.ninjaneers.motager.core.presentation.SplashScreen
import org.ninjaneers.motager.core.presentation.theme.MotagerTheme
import org.ninjaneers.motager.dashboard.presentation.DashboardScreen
import org.ninjaneers.motager.dashboard.presentation.DashboardViewModel
import org.ninjaneers.motager.mainscreen.MainScreen

@Composable
@Preview
fun App() {
    val coreViewModel = koinViewModel<CoreViewModel>()
    val coreState by coreViewModel.state.collectAsStateWithLifecycle()
    CompositionLocalProvider(
        LocalLayoutDirection provides
                if (coreState.language == Language.Arabic)
                    LayoutDirection.Rtl
                else
                    LayoutDirection.Ltr
    ) {
        MotagerTheme(
            darkTheme = when (coreState.theme) {
                Theme.Light -> false
                Theme.Dark -> true
                Theme.System -> isSystemInDarkTheme()
            }
        ) {
            val navController = rememberNavController()
            val navigator = remember { Navigator(navController) }
            NavHost(navController = navController, startDestination = Route.MotagerGraph) {

                navigation<Route.MotagerGraph>(startDestination = Route.Splash) {

                    composable<Route.Splash> {
                        SplashScreen(navigate = { navController.navigate(Route.AuthenticationGraph) })
                    }

                    composable<Route.MainScreen> {
                        MainScreen(navigator = navigator)
                    }

                    navigation<Route.AuthenticationGraph>(startDestination = Route.Login) {
                        composable<Route.Login> {
                            val viewModel = koinViewModel<LoginViewModel>()
                            val state by viewModel.state.collectAsStateWithLifecycle()
                            LoginScreen(
                                state = state,
                                onAction = viewModel::onAction,
                                goToSignup = { navController.navigate(Route.Signup) },
                                goToDashboard = { navController.navigate(Route.DashboardGraph) },
                                coreState = coreState
                            )
                        }
                        composable<Route.Signup> {
                            val viewModel = koinViewModel<SignupViewModel>()
                            val state by viewModel.state.collectAsStateWithLifecycle()
                            SignupScreen(
                                state = state,
                                coreState = coreState,
                                onAction = viewModel::onAction,
                                backToLogin = { navController.navigate(Route.Login) }
                            )
                        }
                    }

                    navigation<Route.DashboardGraph>(startDestination = Route.Dashboard) {
                        composable<Route.Dashboard> {
                            val viewModel = koinViewModel<DashboardViewModel>()
                            val state by viewModel.state.collectAsStateWithLifecycle()
                            DashboardScreen(
                                state = state,
                                coreState = coreState,
                                onAction = viewModel::onAction,
                                coreAction = coreViewModel::onAction,
                                navigator = navigator
                            )
                        }
                    }
                }
            }
        }
    }
}

