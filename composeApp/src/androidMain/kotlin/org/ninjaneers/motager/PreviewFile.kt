package org.ninjaneers.motager

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import org.ninjaneers.motager.app.navigation.Navigator
import org.ninjaneers.motager.core.presentation.theme.MotagerTheme
import org.ninjaneers.motager.dashboard.presentation.home.presentation.HomeScreen

@Composable
@Preview
fun Preview() {
    val navController = rememberNavController()
    MotagerTheme(darkTheme = true) {
        HomeScreen(Navigator(navController))
    }
}

