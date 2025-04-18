package org.ninjaneers.motager.dashboard.presentation.home.presentation.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import motager.composeapp.generated.resources.Res
import motager.composeapp.generated.resources.chevron_down
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.ninjaneers.motager.core.presentation.CoreState
import org.ninjaneers.motager.core.presentation.theme.FontFamily

@Composable
fun ExpandableCard(
    onClick: () -> Unit,
    coreState: CoreState,
    title: StringResource,
    body: StringResource,
    isExpanded: Boolean,
) {
    val animateRotation by animateFloatAsState(
        targetValue = if (isExpanded) 180f else 0f,
    )
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp),
        onClick = {
            onClick()
        },
        shape = RoundedCornerShape(6.dp),
        elevation = CardDefaults.elevatedCardElevation(
            defaultElevation = 0.dp,
            pressedElevation = 0.dp,
            hoveredElevation = 0.dp,
            focusedElevation = 0.dp,
        ),
        colors = CardDefaults.cardColors(
            containerColor = Color.Transparent,
        ),
    ) {
        Column(
            modifier = Modifier.padding(6.dp),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = stringResource(title),
                    fontSize = 16.sp,
                    fontFamily = FontFamily(
                        weight = FontWeight.SemiBold,
                        language = coreState.language,
                    ),
                    color = MaterialTheme.colorScheme.onBackground,
                )
                Icon(
                    modifier = Modifier.rotate(animateRotation),
                    painter = painterResource(Res.drawable.chevron_down),
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.onSurface,
                )
            }
            AnimatedVisibility(
                visible = isExpanded
            ) {
                Text(
                    modifier = Modifier.padding(bottom = 8.dp),
                    text = stringResource(body),
                    fontSize = 16.sp,
                    fontFamily = FontFamily(
                        weight = FontWeight.Normal,
                        language = coreState.language,
                    ),
                    color = MaterialTheme.colorScheme.onBackground
                )
            }
            HorizontalDivider(
                modifier = Modifier.height(0.8f.dp).background(MaterialTheme.colorScheme.outline)
            )
        }
    }
}