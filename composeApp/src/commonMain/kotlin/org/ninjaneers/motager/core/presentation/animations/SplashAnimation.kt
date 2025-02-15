package org.ninjaneers.motager.core.presentation.animations

import KottieAnimation
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import kotlinx.coroutines.launch
import kottieComposition.KottieCompositionSpec
import kottieComposition.animateKottieCompositionAsState
import kottieComposition.rememberKottieComposition
import motager.composeapp.generated.resources.Res
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.ninjaneers.motager.core.domain.Language
import org.ninjaneers.motager.core.domain.Theme

@OptIn(ExperimentalResourceApi::class)
@Composable
fun SplashAnimation(
    theme: Theme,
    language: Language
) {
    val coroutineScope = rememberCoroutineScope()
    var animation by remember { mutableStateOf("") }

    val splashPath: String = if (language == Language.English) {
        when (theme) {
            Theme.Light -> "files/light_en_splash.json"
            Theme.Dark -> "files/dark_en_splash.json"
            Theme.System -> {
                if (isSystemInDarkTheme())
                    "files/dark_en_splash.json"
                else
                    "files/light_en_splash.json"
            }
        }
    } else {
        when (theme) {
            Theme.Light -> "files/light_ar_splash.json"
            Theme.Dark -> "files/dark_ar_splash.json"
            Theme.System -> {
                if (isSystemInDarkTheme())
                    "files/dark_ar_splash.json"
                else
                    "files/light_ar_splash.json"
            }
        }
    }

    coroutineScope.launch {
        animation = Res.readBytes(splashPath).decodeToString()
    }

    val animationComposition = rememberKottieComposition(
        spec = KottieCompositionSpec.File(animation)
    )

    val animationState by animateKottieCompositionAsState(
        composition = animationComposition,
        isPlaying = true
    )
    KottieAnimation(
        modifier = Modifier.fillMaxWidth().scale(1.75f),
        composition = animationComposition,
        progress = { animationState.progress }
    )
}