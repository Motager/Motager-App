package org.ninjaneers.motager.core.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import motager.composeapp.generated.resources.OutfitRegular
import motager.composeapp.generated.resources.Res
import org.jetbrains.compose.resources.Font

@Composable
fun TableStatusCell(
    status: String
) {
    Box(
        modifier = Modifier
            .widthIn(min = 180.dp, max = 180.dp)
            .background(Color.Transparent),
        contentAlignment = Alignment.Center

    ) {
        Text(
            modifier = Modifier.padding(vertical = 8.dp, horizontal = 12.dp)
                .clip(RoundedCornerShape(100.dp))
                .background(
                    when (status) {
                        "Completed" -> Color(0xFF16A34A).copy(alpha = 0.1f)
                        "Pending" -> Color(0xFFEAB308).copy(alpha = 0.1f)
                        "Cancelled" -> Color(0xFFEF4444).copy(alpha = 0.1f)
                        "Processing" -> Color(0xFF60A5FA).copy(alpha = 0.1f)
                        "New" -> Color(0xFF22C55E).copy(alpha = 0.1f)
                        "Active" -> Color(0xFF3B82F6).copy(alpha = 0.1f)
                        "Premium" -> Color(0xFFA855F7).copy(alpha = 0.1f)
                        else -> Color.Transparent
                    }
                )
                .padding(vertical = 2.dp, horizontal = 12.dp),
            text = status,
            fontFamily = FontFamily(
                Font(
                    resource = Res.font.OutfitRegular,
                    weight = FontWeight.Normal
                )
            ),
            fontSize = 18.sp,
            color = when (status) {
                "Completed" -> Color(0xFF16A34A)
                "Pending" -> Color(0xFFEAB308)
                "Cancelled" -> Color(0xFFEF4444)
                "Processing" -> Color(0xFF60A5FA)
                "New" -> Color(0xFF22C55E)
                "Active" -> Color(0xFF3B82F6)
                "Premium" -> Color(0xFFA855F7)
                else -> MaterialTheme.colorScheme.onBackground
            },
            maxLines = 2,
            overflow = TextOverflow.Ellipsis
        )
    }
}