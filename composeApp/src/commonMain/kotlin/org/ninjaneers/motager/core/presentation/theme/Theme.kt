package org.ninjaneers.motager.core.presentation.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val DarkColorScheme = darkColorScheme(
    background = BackgroundDark,
    onBackground = ForegroundDark,
    surface = CardDark,
    onSurface = CardForegroundDark,
    inverseSurface = PopOverDark,
    inverseOnSurface = PopOverForegroundDark,
    surfaceVariant = InputDark,
    primary = PrimaryDark,
    onPrimary = PrimaryForeGroundDark,
    onPrimaryContainer = BackgroundDark,
    secondary = SecondaryDark,
    onSecondary = SecondaryForeGroundDark,
    tertiary = MutedDark,
    onTertiary = MutedForeGroundDark,
    surfaceContainerHigh = Chart_1Dark,
    surfaceContainerLow = Chart_2Dark,
    surfaceContainerHighest = AccentDark,
    surfaceContainerLowest = AccentForeGroundDark,
    error = DestructiveDark,
    onError = DestructiveForeGroundDark,
    outline = BorderDark,
    scrim = RingDark,
)

private val LightColorScheme = lightColorScheme(
    background = BackgroundLight,
    onBackground = ForegroundLight,
    surface = CardLight,
    onSurface = CardForegroundLight,
    inverseSurface = PopOverLight,
    inverseOnSurface = PopOverForegroundLight,
    surfaceVariant = InputLight,
    primary = PrimaryLight,
    onPrimary = PrimaryForeGroundLight,
    onPrimaryContainer = BackgroundLight,
    secondary = SecondaryLight,
    onSecondary = SecondaryForeGroundLight,
    tertiary = MutedLight,
    onTertiary = MutedForeGroundLight,
    surfaceContainerLow = Chart_2Light,
    surfaceContainerHigh = Chart_1Light,
    surfaceContainerHighest = AccentLight,
    surfaceContainerLowest = AccentForeGroundLight,
    error = DestructiveLight,
    onError = DestructiveForeGroundLight,
    outline = BorderLight,
    scrim = RingLight,
)

@Composable
fun MotagerTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        content = content
    )
}