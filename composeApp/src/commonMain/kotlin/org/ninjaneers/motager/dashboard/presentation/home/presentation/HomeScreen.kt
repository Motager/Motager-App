package org.ninjaneers.motager.dashboard.presentation.home.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.launch
import org.ninjaneers.motager.app.navigation.Navigator
import org.ninjaneers.motager.dashboard.presentation.components.NavDrawer
import org.ninjaneers.motager.dashboard.presentation.components.TopBar

@Composable
fun HomeScreen(
    navigator: Navigator
) {
    HomeScreenContent(
        navigator = navigator
    )
}

@Composable
private fun HomeScreenContent(
    navigator: Navigator
) {
    val scope = rememberCoroutineScope()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    ModalNavigationDrawer(
        drawerContent = {
            NavDrawer(navigator = navigator)
        },
        drawerState = drawerState,
        scrimColor = MaterialTheme.colorScheme.background.copy(alpha = 0.5f)
    ) {
        Scaffold(
            topBar = {
                TopBar(
                    openNavDrawer = {
                        scope.launch(Dispatchers.IO) {
                            drawerState.open()
                        }
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
//}
