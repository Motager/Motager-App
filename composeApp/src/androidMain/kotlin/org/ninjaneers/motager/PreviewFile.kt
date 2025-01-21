package org.ninjaneers.motager

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import org.ninjaneers.motager.core.presentation.theme.MotagerTheme
import org.ninjaneers.motager.products.presentation.ProductsScreen

@Composable
@Preview
fun Preview() {
    MotagerTheme(darkTheme = true) {
        ProductsScreen()
    }
}

