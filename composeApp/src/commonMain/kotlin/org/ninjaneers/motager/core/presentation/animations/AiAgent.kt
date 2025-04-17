package org.ninjaneers.motager.core.presentation.animations

import KottieAnimation
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.unit.dp
import kottieComposition.KottieCompositionSpec
import kottieComposition.animateKottieCompositionAsState
import kottieComposition.rememberKottieComposition
import motager.composeapp.generated.resources.Res
import org.jetbrains.compose.resources.ExperimentalResourceApi

@OptIn(ExperimentalResourceApi::class)
@Composable
fun AiAgent(
    modifier: Modifier = Modifier
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
        modifier = modifier.padding(top = 16.dp, end = 8.dp).size(120.dp).scale(1.65f),
        composition = animationComposition,
        progress = { animationState.progress }
    )
}