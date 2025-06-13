package org.ninjaneers.motager.core.presentation.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonElevation
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp
import org.ninjaneers.motager.core.domain.Language

@Composable
fun PrimaryIconButton(
    expanded: Boolean = false,
    onClick: () -> Unit,
    painter: Painter,
    language: Language,
    iconTint: Color = MaterialTheme.colorScheme.onSecondary,
    colors: ButtonColors = ButtonDefaults.buttonColors(),
    modifier: Modifier = Modifier.size(40.dp),
    enabled: Boolean = true,
    shape: Shape = RoundedCornerShape(6.dp),
    elevation: ButtonElevation? = ButtonDefaults.buttonElevation(),
    border: BorderStroke = BorderStroke(
        width = if (expanded) 1.6f.dp else 0.8.dp,
        color = if (expanded) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.outline
    ),
) {
    Button(
        modifier = modifier,
        onClick = onClick,
        contentPadding = PaddingValues(0.dp),
        elevation = elevation,
        border = border,
        enabled = enabled,
        shape = shape,
        colors = colors
    ) {
        Icon(
            painter = painter,
            contentDescription = "more",
            tint = iconTint,
            modifier = Modifier.graphicsLayer {
                if (language == Language.Arabic)
                    scaleX = -1f
            }
        )
    }
}