package org.ninjaneers.motager.dashboard.presentation.discounts.presentation


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import org.ninjaneers.motager.core.presentation.CoreAction
import org.ninjaneers.motager.core.presentation.CoreState
import org.ninjaneers.motager.dashboard.presentation.DashboardAction
import org.ninjaneers.motager.dashboard.presentation.DashboardState

@Composable
fun DiscountsScreen(
    dashboardState: DashboardState,
    coreState: CoreState,
    dashboardAction: suspend (DashboardAction) -> Unit,
    coreAction: (CoreAction) -> Unit
) {
    DiscountsScreenContent(
        dashboardState = dashboardState,
        dashboardAction = dashboardAction,
        coreState = coreState,
        coreAction = coreAction
    )
}

@Composable
private fun DiscountsScreenContent(
    dashboardState: DashboardState,
    coreState: CoreState,
    dashboardAction: suspend (DashboardAction) -> Unit,
    coreAction: (CoreAction) -> Unit
) {
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
