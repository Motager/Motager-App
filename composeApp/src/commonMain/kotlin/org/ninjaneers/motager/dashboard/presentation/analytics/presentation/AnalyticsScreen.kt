package org.ninjaneers.motager.dashboard.presentation.analytics.presentation


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import motager.composeapp.generated.resources.Coming_Soon
import motager.composeapp.generated.resources.Res
import org.jetbrains.compose.resources.stringResource
import org.ninjaneers.motager.core.presentation.CoreState
import org.ninjaneers.motager.core.presentation.theme.FontFamily

@Composable
fun AnalyticsScreen(
    coreState: CoreState,
) {
    AnalyticsScreenContent(
        coreState = coreState,
    )
}

@Composable
private fun AnalyticsScreenContent(
    coreState: CoreState,
) {
    Column(
        modifier = Modifier
            .clip(RoundedCornerShape(6.dp))
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.secondary.copy(alpha = 0.5f))
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = stringResource(Res.string.Coming_Soon),
            fontSize = 32.sp,
            fontFamily = FontFamily(
                weight = FontWeight.ExtraBold,
                language = coreState.language
            ),
            color = MaterialTheme.colorScheme.primary
        )
    }
}


