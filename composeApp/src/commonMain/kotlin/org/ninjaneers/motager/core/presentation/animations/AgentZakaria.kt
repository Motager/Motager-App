package org.ninjaneers.motager.core.presentation.animations

import KottieAnimation
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import kottieComposition.KottieCompositionSpec
import kottieComposition.animateKottieCompositionAsState
import kottieComposition.rememberKottieComposition
import motager.composeapp.generated.resources.Res
import org.jetbrains.compose.resources.ExperimentalResourceApi

@OptIn(ExperimentalResourceApi::class)
@Composable
fun AgentZakaria(
    modifier: Modifier = Modifier,
) {
    var animation by remember { mutableStateOf("") }
    LaunchedEffect(Unit) {
        animation = Res.readBytes("files/zakaria_ai.json").decodeToString()
    }
    val animationComposition = rememberKottieComposition(
        spec = KottieCompositionSpec.File(animation)
    )

    val animationState by animateKottieCompositionAsState(
        composition = animationComposition,
        isPlaying = true,
        iterations = Int.MAX_VALUE
    )
    KottieAnimation(
        modifier = modifier,
        composition = animationComposition,
        progress = { animationState.progress }
    )
}