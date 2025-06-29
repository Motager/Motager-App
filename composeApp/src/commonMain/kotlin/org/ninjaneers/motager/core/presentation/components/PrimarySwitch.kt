package org.ninjaneers.motager.core.presentation.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun PrimarySwitch(
    modifier: Modifier = Modifier,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
) {
    Switch(
        modifier = modifier.padding(end = 12.dp),
        checked = checked,
        onCheckedChange = { onCheckedChange(it) },
        colors = SwitchDefaults.colors(
            checkedThumbColor = MaterialTheme.colorScheme.background,
            uncheckedThumbColor = MaterialTheme.colorScheme.background,
            uncheckedTrackColor = MaterialTheme.colorScheme.surfaceVariant,
            checkedTrackColor = MaterialTheme.colorScheme.primary,
        )
    )
}