package org.ninjaneers.motager.core.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import kotlinx.coroutines.delay
import org.ninjaneers.motager.core.domain.Language
import org.ninjaneers.motager.core.domain.Theme
import org.ninjaneers.motager.core.presentation.animations.SplashAnimation

@Composable
fun SplashScreen(
    navigate: () -> Unit,
    theme: Theme,
    language: Language
) {
    LaunchedEffect(Unit) {
        delay(4300L)
        navigate()
    }
    Column(
        modifier = Modifier.fillMaxSize().background(MaterialTheme.colorScheme.background),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        SplashAnimation(
            theme = theme,
            language = language
        )
    }
}