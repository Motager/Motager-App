package org.ninjaneers.motager.core.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import motager.composeapp.generated.resources.DarkLogoEn
import motager.composeapp.generated.resources.LightLogoEn
import motager.composeapp.generated.resources.Res
import motager.composeapp.generated.resources.avatar
import motager.composeapp.generated.resources.bell
import motager.composeapp.generated.resources.panels
import org.jetbrains.compose.resources.painterResource

@Composable
fun TopBar() {
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
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            PrimaryIconButton(
                onClick = {},
                painter = painterResource(Res.drawable.panels),
                iconTint = MaterialTheme.colorScheme.onBackground,
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.background,
                    MaterialTheme.colorScheme.surfaceContainerLowest
                )
            )
            Image(
                modifier = Modifier
                    .width(150.dp)
                    .height(38.dp),
                painter = if (isSystemInDarkTheme())
                    painterResource(Res.drawable.DarkLogoEn)
                else painterResource(Res.drawable.LightLogoEn),
                contentDescription = "Logo"
            )
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            PrimaryIconButton(
                onClick = {},
                painter = painterResource(Res.drawable.bell),
                iconTint = MaterialTheme.colorScheme.onBackground,
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.background,
                    MaterialTheme.colorScheme.surfaceContainerLowest
                )
            )
            Image(
                modifier = Modifier
                    .clip(RoundedCornerShape(1000.dp))
                    .background(MaterialTheme.colorScheme.primary)
                    .size(40.dp),
                painter = painterResource(Res.drawable.avatar),
                contentDescription = "Logo"
            )
        }
    }
}