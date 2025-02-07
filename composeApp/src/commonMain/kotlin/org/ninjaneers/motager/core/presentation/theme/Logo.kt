package org.ninjaneers.motager.core.presentation.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import motager.composeapp.generated.resources.DarkLogoAr
import motager.composeapp.generated.resources.DarkLogoEn
import motager.composeapp.generated.resources.LightLogoAr
import motager.composeapp.generated.resources.LightLogoEn
import motager.composeapp.generated.resources.Res
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
            Theme.Light -> painterResource(Res.drawable.LightLogoEn)
            Theme.Dark -> painterResource(Res.drawable.DarkLogoEn)
            Theme.System -> {
                if (isSystemInDarkTheme())
                    painterResource(Res.drawable.DarkLogoEn)
                else
                    painterResource(Res.drawable.LightLogoEn)
            }
        }
    } else {
        when (theme) {
            Theme.Light -> painterResource(Res.drawable.LightLogoAr)
            Theme.Dark -> painterResource(Res.drawable.DarkLogoAr)
            Theme.System -> {
                if (isSystemInDarkTheme())
                    painterResource(Res.drawable.DarkLogoAr)
                else
                    painterResource(Res.drawable.LightLogoAr)
            }
        }
    }
}