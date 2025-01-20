package org.ninjaneers.motager

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import org.ninjaneers.motager.core.presentation.theme.MotagerTheme
import org.ninjaneers.motager.orders.presentation.OrdersScreen

@Composable
@Preview
@PreviewScreenSizes
//@PreviewLightDark
fun Preview() {
    MotagerTheme(darkTheme = true) {
        OrdersScreen()
    }
}


