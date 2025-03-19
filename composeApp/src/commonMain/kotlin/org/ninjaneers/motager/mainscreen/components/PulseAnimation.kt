import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun PulseAnimation(
) {
    Box(
        contentAlignment = Alignment.Center
    ) {
        // Create 8 concentric circles with increasing sizes and optimized delays
        val circleData = listOf(
            CircleData(30.dp, 0.05f, 0.24f, 0, false),
            CircleData(70.dp, 0.1f, 0.21f, 60, false),
            CircleData(140.dp, 0.15f, 0.18f, 120, false),
            CircleData(210.dp, 0.2f, 0.15f, 180, false),
            CircleData(280.dp, 0.25f, 0.12f, 240, false),
            CircleData(350.dp, 0.3f, 0.09f, 300, false),
            CircleData(420.dp, 0.35f, 0.06f, 360, false),
        )

        circleData.forEach { data ->
            PulseCircleWithDelay(
                size = data.size,
                baseOpacity = data.opacity,
                borderOpacity = data.borderOpacity,
                delayMillis = data.delayMillis,
                isDashed = data.isDashed,
                primaryColor = MaterialTheme.colorScheme.primary
            )
        }
    }
}

/**
 * Data class to hold properties for each pulse circle
 */
private data class CircleData(
    val size: androidx.compose.ui.unit.Dp,
    val opacity: Float,
    val borderOpacity: Float,
    val delayMillis: Int,
    val isDashed: Boolean
)

@Composable
private fun PulseCircleWithDelay(
    size: androidx.compose.ui.unit.Dp,
    baseOpacity: Float,
    borderOpacity: Float,
    delayMillis: Int,
    isDashed: Boolean,
    primaryColor: Color
) {
    val infiniteTransition = rememberInfiniteTransition()

    // Scale animation from 1.0 to 1.1 and back with the specified delay
    val scale by infiniteTransition.animateFloat(
        initialValue = 1f,
        targetValue = 1.1f,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 1000,
                easing = FastOutSlowInEasing,
                delayMillis = delayMillis
            ),
            repeatMode = RepeatMode.Reverse
        )
    )

    Box(
        modifier = Modifier
            .size(size)
            .scale(scale)
            .clip(CircleShape)
            .background(primaryColor.copy(alpha = baseOpacity * 0.25f))
            .shadow(
                elevation = 4.dp,
                shape = CircleShape,
                clip = true,
                ambientColor = primaryColor.copy(alpha = baseOpacity * 0.1f),
                spotColor = primaryColor.copy(alpha = baseOpacity * 0.1f)
            )
            .border(
                width = 1.dp,
                color = primaryColor.copy(alpha = borderOpacity),
                shape = CircleShape
            )
    )
}
