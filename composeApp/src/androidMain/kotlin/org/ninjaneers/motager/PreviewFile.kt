package org.ninjaneers.motager

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import org.ninjaneers.motager.core.presentation.mainScreen.MainScreen
import org.ninjaneers.motager.core.presentation.theme.MotagerTheme

@Composable
@Preview
fun Preview() {
    MotagerTheme(darkTheme = true) {
        MainScreen()
    }
}

