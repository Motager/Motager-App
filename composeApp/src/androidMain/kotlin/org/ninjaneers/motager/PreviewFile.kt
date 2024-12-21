package org.ninjaneers.motager

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewLightDark
import org.ninjaneers.motager.Authentication.presentation.mainScreen.MainScreen
import org.ninjaneers.motager.core.presentation.theme.MotagerTheme

@Composable
@PreviewLightDark()
@Preview(locale = "ar")
@Preview(locale = "en")
fun Preview() {
    MotagerTheme {
        MainScreen()
    }
}