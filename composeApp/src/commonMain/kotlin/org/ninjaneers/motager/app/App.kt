package org.ninjaneers.motager.app

import androidx.compose.runtime.Composable
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.ninjaneers.motager.core.presentation.theme.MotagerTheme
import org.ninjaneers.motager.products.presentation.ProductsScreen

@Composable
@Preview
fun App() {
    MotagerTheme {
        ProductsScreen()
    }
}