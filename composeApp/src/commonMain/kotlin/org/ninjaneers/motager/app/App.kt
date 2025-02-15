package org.ninjaneers.motager.app

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.LayoutDirection
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.viewmodel.koinViewModel
import org.ninjaneers.motager.app.navigation.NavigationGraph
import org.ninjaneers.motager.core.domain.Language
import org.ninjaneers.motager.core.domain.Theme
import org.ninjaneers.motager.core.presentation.CoreViewModel
import org.ninjaneers.motager.core.presentation.theme.MotagerTheme

@Composable
@Preview
fun App() {
    val coreViewModel = koinViewModel<CoreViewModel>()
    val coreState by coreViewModel.state.collectAsStateWithLifecycle()
    CompositionLocalProvider(
        LocalLayoutDirection provides
                if (coreState.language == Language.Arabic)
                    LayoutDirection.Rtl
                else
                    LayoutDirection.Ltr
    ) {
        MotagerTheme(
            darkTheme = when (coreState.theme) {
                Theme.Light -> false
                Theme.Dark -> true
                Theme.System -> isSystemInDarkTheme()
            }
        ) {
            NavigationGraph(
                coreState = coreState,
                coreAction = coreViewModel::onAction
            )
        }
    }
}

