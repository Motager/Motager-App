package org.ninjaneers.motager.core.presentation.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import motager.composeapp.generated.resources.Res
import motager.composeapp.generated.resources.dark_ar_logo
import motager.composeapp.generated.resources.dark_en_logo
import motager.composeapp.generated.resources.light_ar_logo
import motager.composeapp.generated.resources.light_en_logo
import org.jetbrains.compose.resources.painterResource
import org.ninjaneers.motager.core.domain.Language
import org.ninjaneers.motager.core.domain.Theme


@Composable
fun Logo(
    language: Language,
    theme: Theme
): Painter {
    return if (language == Language.English) {
        when (theme) {
            Theme.Light -> painterResource(Res.drawable.light_en_logo)
            Theme.Dark -> painterResource(Res.drawable.dark_en_logo)
            Theme.System -> {
                if (isSystemInDarkTheme())
                    painterResource(Res.drawable.dark_en_logo)
                else
                    painterResource(Res.drawable.light_en_logo)
            }
        }
    } else {
        when (theme) {
            Theme.Light -> painterResource(Res.drawable.light_ar_logo)
            Theme.Dark -> painterResource(Res.drawable.dark_ar_logo)
            Theme.System -> {
                if (isSystemInDarkTheme())
                    painterResource(Res.drawable.dark_ar_logo)
                else
                    painterResource(Res.drawable.light_ar_logo)
            }
        }
    }
}