package org.ninjaneers.motager.dashboard.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import kotlinx.coroutines.launch
import motager.composeapp.generated.resources.Res
import motager.composeapp.generated.resources.bell
import motager.composeapp.generated.resources.panels
import org.jetbrains.compose.resources.painterResource
import org.ninjaneers.motager.core.presentation.CoreState
import org.ninjaneers.motager.core.presentation.components.PrimaryIconButton
import org.ninjaneers.motager.core.presentation.theme.Logo
import org.ninjaneers.motager.dashboard.presentation.DashboardAction


@Composable
fun TopBar(
    coreState: CoreState,
    openNavDrawer: suspend (DashboardAction) -> Unit,
    avatar: String = "https://motager.vercel.app/images/male.png"
) {
    val coroutineScope = rememberCoroutineScope()
    Row(
        modifier = Modifier
            .windowInsetsPadding(WindowInsets.statusBars)
            .padding(horizontal = 8.dp)
            .clip(RoundedCornerShape(6.dp))
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.secondary)
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            PrimaryIconButton(
                onClick = {
                    coroutineScope.launch { openNavDrawer(DashboardAction.OpenNavigationDrawer) }
                },
                painter = painterResource(Res.drawable.panels),
                iconTint = MaterialTheme.colorScheme.onBackground,
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.background,
                    MaterialTheme.colorScheme.surfaceContainerLowest
                ),
                language = coreState.language
            )
            Image(
                modifier = Modifier
                    .width(150.dp)
                    .height(38.dp),
                painter = Logo(
                    language = coreState.language,
                    theme = coreState.theme
                ),
                contentDescription = "Logo"
            )
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            PrimaryIconButton(
                onClick = {},
                painter = painterResource(Res.drawable.bell),
                iconTint = MaterialTheme.colorScheme.onBackground,
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.background,
                    MaterialTheme.colorScheme.surfaceContainerLowest
                ),
                language = coreState.language
            )
            AsyncImage(
                modifier = Modifier
                    .clip(RoundedCornerShape(100.dp))
                    .background(MaterialTheme.colorScheme.primary)
                    .size(40.dp),
                model = avatar,
                contentDescription = "Logo"
            )
        }
    }
}