package org.ninjaneers.motager.core.presentation.animations

import KottieAnimation
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import kottieComposition.KottieCompositionSpec
import kottieComposition.animateKottieCompositionAsState
import kottieComposition.rememberKottieComposition
import motager.composeapp.generated.resources.Res
import org.jetbrains.compose.resources.ExperimentalResourceApi

@OptIn(ExperimentalResourceApi::class)
@Composable
fun SplashAnimation() {
    var animation by remember { mutableStateOf("") }

    LaunchedEffect(Unit) {
        animation = Res.readBytes("files/splash.json").decodeToString()
    }

    val animationComposition = rememberKottieComposition(
        spec = KottieCompositionSpec.File(animation)
    )

    val animationState by animateKottieCompositionAsState(
        composition = animationComposition,
        isPlaying = true
    )
    KottieAnimation(
        modifier = Modifier.fillMaxWidth().scale(2f),
        composition = animationComposition,
        progress = { animationState.progress }
    )
}