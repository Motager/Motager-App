package org.ninjaneers.motager.dashboard.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import motager.composeapp.generated.resources.Res
import motager.composeapp.generated.resources.vellipsis
import org.jetbrains.compose.resources.painterResource

@Composable
fun TableActionCell() {
    Box(
        modifier = Modifier
            .widthIn(min = 180.dp, max = 180.dp)
            .background(Color.Transparent),
        contentAlignment = Alignment.Center
    ) {
        IconButton(
            onClick = {},
            colors = IconButtonDefaults.iconButtonColors(
                contentColor = MaterialTheme.colorScheme.surfaceContainerLowest
            )
        ) {
            Icon(
                modifier = Modifier.size(24.dp),
                painter = painterResource(Res.drawable.vellipsis),
                contentDescription = null,
                tint = MaterialTheme.colorScheme.onBackground
            )
        }
    }
}