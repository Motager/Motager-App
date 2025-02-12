package org.ninjaneers.motager.dashboard.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import motager.composeapp.generated.resources.OutfitMedium
import motager.composeapp.generated.resources.Res
import org.jetbrains.compose.resources.Font


@Composable
fun NavDrawerHeader(
    avatar: String = "https://motager.vercel.app/images/male.png"
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.background)
            .padding(),
        verticalArrangement = Arrangement.spacedBy(6.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AsyncImage(
            modifier = Modifier
                .clip(RoundedCornerShape(100.dp))
                .size(80.dp)
                .background(MaterialTheme.colorScheme.primary),
            model = avatar,
            contentDescription = null
        )
        Text(
            text = "User Name",
            fontFamily = FontFamily(
                Font(
                    resource = Res.font.OutfitMedium,
                    weight = FontWeight.Medium
                )
            ),
            color = MaterialTheme.colorScheme.onBackground,
            fontSize = 20.sp,
            textAlign = TextAlign.Start
        )
        Text(
            text = "Store Name",
            fontFamily = FontFamily(
                Font(
                    resource = Res.font.OutfitMedium,
                    weight = FontWeight.Medium
                )
            ),
            color = MaterialTheme.colorScheme.onBackground,
            fontSize = 28.sp,
            textAlign = TextAlign.Start
        )
    }
}