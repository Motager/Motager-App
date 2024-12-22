package org.ninjaneers.motager

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.content.res.Resources.Theme
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewLightDark
import org.ninjaneers.motager.Authentication.presentation.LoginScreen
import org.ninjaneers.motager.Authentication.presentation.mainScreen.MainScreen
import org.ninjaneers.motager.core.presentation.theme.MotagerTheme

@Composable
@Preview(locale = "ar",uiMode = UI_MODE_NIGHT_YES)
@PreviewLightDark
fun Preview() {
    MotagerTheme() {
        LoginScreen()
    }
}