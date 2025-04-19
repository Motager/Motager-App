package org.ninjaneers.motager

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import org.ninjaneers.motager.core.presentation.CoreState
import org.ninjaneers.motager.core.presentation.theme.MotagerTheme
import org.ninjaneers.motager.dashboard.presentation.products.presentation.AddProductScreen
import org.ninjaneers.motager.dashboard.presentation.products.presentation.AddProductState

@Composable
@Preview
fun Preview() {
    MotagerTheme(darkTheme = false) {
        AddProductScreen(
            state = AddProductState(),
            onAction = {},
            coreState = CoreState(),
            dashboardAction = {}
        )
    }
}

