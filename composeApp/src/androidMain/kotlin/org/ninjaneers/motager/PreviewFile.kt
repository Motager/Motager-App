package org.ninjaneers.motager
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.PreviewLightDark
import org.ninjaneers.motager.Authentication.presentation.login.LoginScreen
import org.ninjaneers.motager.core.presentation.theme.MotagerTheme

@Composable
@PreviewLightDark
fun Preview() {
    MotagerTheme {
        LoginScreen()
    }
}
