package org.ninjaneers.motager.core.presentation.mainScreen.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SwitchButton(image: Painter) {
    Button(
        onClick = {},
        modifier = Modifier.size(40.dp),
        shape = RoundedCornerShape(6.dp),
        contentPadding = PaddingValues(8.dp),
        colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.secondary)
    ) {
       Icon(
           painter = image,
           contentDescription = "logo",
           tint = MaterialTheme.colorScheme.onBackground
       )
    }
}
