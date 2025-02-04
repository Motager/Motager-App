package org.ninjaneers.motager.dashboard.presentation.analytics.presentation


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import org.ninjaneers.motager.app.navigation.Navigator
import org.ninjaneers.motager.core.presentation.CoreAction
import org.ninjaneers.motager.core.presentation.CoreState
import org.ninjaneers.motager.dashboard.presentation.DashboardAction
import org.ninjaneers.motager.dashboard.presentation.DashboardState
import org.ninjaneers.motager.dashboard.presentation.components.NavDrawer
import org.ninjaneers.motager.dashboard.presentation.components.TopBar

@Composable
fun AnalyticsScreen(
    navigator: Navigator,
    dashboardState: DashboardState,
    onAction: suspend (DashboardAction) -> Unit,
    coreState: CoreState,
    coreAction: (CoreAction) -> Unit
) {
    AnalyticsScreenContent(
        navigator = navigator,
        dashboardState = dashboardState,
        onAction = onAction,
        coreState = coreState,
        coreAction = coreAction
    )
}

@Composable
private fun AnalyticsScreenContent(
    navigator: Navigator,
    dashboardState: DashboardState,
    onAction: suspend (DashboardAction) -> Unit,
    coreState: CoreState,
    coreAction: (CoreAction) -> Unit
) {
    ModalNavigationDrawer(
        drawerContent = {
            NavDrawer(
                navigator = navigator,
                navigationItems = dashboardState.navigationItems,
                closeDrawer = onAction,
                coreAction = coreAction
            )
        },
        drawerState = dashboardState.drawerState,
        scrimColor = MaterialTheme.colorScheme.background.copy(alpha = 0.5f)
    ) {
        Scaffold(
            topBar = {
                TopBar(
                    openNavDrawer = onAction
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
//                AnimatedVisibility(
//                    visible = true,
//                    enter = slideInVertically(
//                        animationSpec = spring(
//                            dampingRatio = Spring.DampingRatioMediumBouncy,
//                            stiffness = Spring.StiffnessMediumLow
//                        )
//                    ),
//                ) {
                Column(
                    modifier = Modifier
                        .clip(RoundedCornerShape(6.dp))
                        .fillMaxSize()
                        .background(MaterialTheme.colorScheme.secondary.copy(alpha = 0.5f))
                        .padding(8.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {}
            }
        }
    }
}

