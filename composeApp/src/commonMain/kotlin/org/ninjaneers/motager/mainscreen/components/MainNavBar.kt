package org.ninjaneers.motager.mainscreen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import motager.composeapp.generated.resources.Login_Signup
import motager.composeapp.generated.resources.OutfitMedium
import motager.composeapp.generated.resources.Res
import motager.composeapp.generated.resources.menu
import org.jetbrains.compose.resources.Font
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.ninjaneers.motager.core.domain.Language
import org.ninjaneers.motager.core.presentation.components.PrimaryButton
import org.ninjaneers.motager.core.presentation.components.PrimaryIconButton

@Composable
fun MainNavBar() {
    Row(
        modifier = Modifier
            .clip(RoundedCornerShape(6.dp))
            .fillMaxWidth()
            .height(56.dp)
            .background(MaterialTheme.colorScheme.secondary)
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
//        Image(
//            modifier = Modifier.width(150.dp).height(38.dp),
//            painter = painterResource(Res.drawable.light_en_logo),
//            contentDescription = "Logo"
//        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            PrimaryButton(
                modifier = Modifier
                    .height(42.dp)
                    .wrapContentWidth(),
                onClick = {},
                contentPadding = PaddingValues(
                    horizontal = 16.dp,
                    vertical = 8.dp
                ),
                shape = RoundedCornerShape(6.dp)
            ) {
                Text(
                    text = stringResource(Res.string.Login_Signup),
                    fontFamily = FontFamily(
                        Font(
                            resource = Res.font.OutfitMedium,
                            weight = FontWeight.Medium,
                        )
                    ),
                    color = MaterialTheme.colorScheme.onPrimary
                )
            }
            PrimaryIconButton(
                onClick = {},
                painter = painterResource(Res.drawable.menu),
                iconTint = MaterialTheme.colorScheme.onBackground,
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.background,
                    contentColor = MaterialTheme.colorScheme.surfaceContainerLowest
                ),
                language = Language.English
            )
        }
    }
}