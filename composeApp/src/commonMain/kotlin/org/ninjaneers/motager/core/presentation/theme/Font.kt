package org.ninjaneers.motager.core.presentation.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import motager.composeapp.generated.resources.ElMessiriBold
import motager.composeapp.generated.resources.ElMessiriMedium
import motager.composeapp.generated.resources.ElMessiriRegular
import motager.composeapp.generated.resources.ElMessiriSemiBold
import motager.composeapp.generated.resources.OutfitBold
import motager.composeapp.generated.resources.OutfitMedium
import motager.composeapp.generated.resources.OutfitRegular
import motager.composeapp.generated.resources.OutfitSemiBold
import motager.composeapp.generated.resources.Res
import org.jetbrains.compose.resources.Font
import org.ninjaneers.motager.core.domain.Language

val OutfitBold = Res.font.OutfitBold
val OutfitSemiBold = Res.font.OutfitSemiBold
val OutfitMedium = Res.font.OutfitMedium
val OutfitRegular = Res.font.OutfitRegular
val ElmessiriBold = Res.font.ElMessiriBold
val ElmessiriSemiBold = Res.font.ElMessiriSemiBold
val ElmessiriMedium = Res.font.ElMessiriMedium
val ElmessiriRegular = Res.font.ElMessiriRegular

@Composable
fun FontFamily(
    weight: FontWeight,
    language: Language
): FontFamily? {
    return if (language == Language.English) {
        when (weight) {
            FontWeight.Bold -> FontFamily(
                Font(
                    resource = OutfitBold,
                    weight = weight
                )
            )

            FontWeight.SemiBold -> FontFamily(
                Font(
                    resource = OutfitSemiBold,
                    weight = weight
                )
            )

            FontWeight.Medium -> FontFamily(
                Font(
                    resource = OutfitMedium,
                    weight = weight
                )
            )

            FontWeight.Normal -> FontFamily(
                Font(
                    resource = OutfitRegular,
                    weight = weight
                )
            )

            else -> null
        }
    } else {
        when (weight) {
            FontWeight.Bold -> FontFamily(
                Font(
                    resource = ElmessiriBold,
                    weight = weight
                )
            )

            FontWeight.SemiBold -> FontFamily(
                Font(
                    resource = ElmessiriSemiBold,
                    weight = weight
                )
            )

            FontWeight.Medium -> FontFamily(
                Font(
                    resource = ElmessiriMedium,
                    weight = weight
                )
            )

            FontWeight.Normal -> FontFamily(
                Font(
                    resource = ElmessiriRegular,
                    weight = weight
                )
            )

            else -> null
        }
    }
}
