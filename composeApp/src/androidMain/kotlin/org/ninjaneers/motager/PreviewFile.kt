package org.ninjaneers.motager
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.PreviewLightDark
import org.ninjaneers.motager.Authentication.presentation.SignupScreen
import org.ninjaneers.motager.core.presentation.theme.MotagerTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@PreviewLightDark()
//@Preview(locale = "ar", uiMode = UI_MODE_NIGHT_YES)
//@Preview(locale = "en")
fun Preview() {


    MotagerTheme {
        SignupScreen()

    }
}
