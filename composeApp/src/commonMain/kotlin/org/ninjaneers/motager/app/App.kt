package org.ninjaneers.motager.app

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import motager.composeapp.generated.resources.Res
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.ninjaneers.motager.Authentication.presentation.SignupScreen
import org.ninjaneers.motager.core.presentation.theme.MotagerTheme
@Composable
@Preview
fun App() {
    MotagerTheme {

        SignupScreen()
    }
}