package org.ninjaneers.motager.dashboard.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import motager.composeapp.generated.resources.Res
import motager.composeapp.generated.resources.product_placeholder
import org.jetbrains.compose.resources.painterResource

@Composable
fun TableImageCell() {
    Box(
        modifier = Modifier
            .widthIn(min = 180.dp, max = 180.dp)
            .background(Color.Transparent),
        contentAlignment = Alignment.Center
    ) {
        Image(
            modifier = Modifier
                .padding(vertical = 8.dp)
                .size(60.dp)
                .border(
                    width = 0.8f.dp,
                    color = MaterialTheme.colorScheme.outline,
                    shape = RoundedCornerShape(6.dp)
                )
                .clip(
                    RoundedCornerShape(6.dp)
                ),
            painter = painterResource(Res.drawable.product_placeholder),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
    }
}