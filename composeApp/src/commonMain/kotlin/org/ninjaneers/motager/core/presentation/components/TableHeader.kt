package org.ninjaneers.motager.core.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import motager.composeapp.generated.resources.OutfitBold
import motager.composeapp.generated.resources.Res
import org.jetbrains.compose.resources.Font

@Composable
fun TableHeader(
    headers: List<String>
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(40.dp)
    ) {
        headers.forEach { header ->
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .widthIn(min = 200.dp, max = 200.dp)
                    .background(MaterialTheme.colorScheme.secondary),
                contentAlignment = Alignment.Center

            ) {
                Row(
                    modifier = Modifier.padding(horizontal = 12.dp),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    Text(
                        text = header,
                        fontFamily = FontFamily(
                            Font(
                                resource = Res.font.OutfitBold,
                                weight = FontWeight.Bold
                            )
                        ),
                        fontSize = 18.sp,
                        color = MaterialTheme.colorScheme.onTertiary,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }
        }
    }
}