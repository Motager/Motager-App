package org.ninjaneers.motager.dashboard.presentation.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
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
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.composables.icons.lucide.CircleHelp
import com.composables.icons.lucide.LogOut
import com.composables.icons.lucide.Lucide
import com.composables.icons.lucide.UserRoundPen
import kotlinx.coroutines.launch
import motager.composeapp.generated.resources.Help
import motager.composeapp.generated.resources.Logout
import motager.composeapp.generated.resources.Profile
import motager.composeapp.generated.resources.Res
import motager.composeapp.generated.resources.bell
import motager.composeapp.generated.resources.panels
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.ninjaneers.motager.core.data.network.AVATAR_HOST
import org.ninjaneers.motager.core.presentation.CoreState
import org.ninjaneers.motager.core.presentation.components.PrimaryIconButton
import org.ninjaneers.motager.core.presentation.theme.FontFamily
import org.ninjaneers.motager.core.presentation.theme.Logo
import org.ninjaneers.motager.dashboard.presentation.DashboardAction
import org.ninjaneers.motager.dashboard.presentation.DashboardState


@Composable
fun TopBar(
    coreState: CoreState,
    dashboardState: DashboardState,
    onAction: suspend (DashboardAction) -> Unit,
    onLogout: () -> Unit,
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
                    coroutineScope.launch { onAction(DashboardAction.OpenNavigationDrawer) }
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
            Box {
                AsyncImage(
                    modifier = Modifier
                        .clip(RoundedCornerShape(50.dp))
                        .background(MaterialTheme.colorScheme.background)
                        .border(
                            width = if (dashboardState.isProfileMenuExpanded) 1.6f.dp else 0.8f.dp,
                            color = if (dashboardState.isProfileMenuExpanded) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.outline,
                            shape = RoundedCornerShape(50.dp)
                        )
                        .size(40.dp)
                        .clickable {
                            coroutineScope.launch {
                                onAction(DashboardAction.OnProfileMenuToggle)
                            }
                        },
                    model = (AVATAR_HOST + coreState.user?.name),
                    contentDescription = "Logo"
                )
                DropdownMenu(
                    modifier = Modifier.fillMaxWidth(0.5f),
                    expanded = dashboardState.isProfileMenuExpanded,
                    onDismissRequest = {
                        coroutineScope.launch {
                            onAction(DashboardAction.OnProfileMenuToggle)
                        }
                    },
                    border = BorderStroke(
                        width = 0.8f.dp,
                        color = MaterialTheme.colorScheme.outline
                    ),
                    offset = DpOffset(0.dp, 4.dp),
                    shape = RoundedCornerShape(6.dp),
                    containerColor = MaterialTheme.colorScheme.inverseSurface
                ) {
                    DropdownMenuItem(
                        enabled = false,
                        modifier = Modifier.padding(horizontal = 4.dp)
                            .clip(RoundedCornerShape(6.dp)),
                        onClick = {},
                        text = {
                            Column(
                                horizontalAlignment = Alignment.Start,
                                verticalArrangement = Arrangement.spacedBy(4.dp)
                            ) {
                                coreState.user?.let {
                                    Text(
                                        text = it.name,
                                        fontSize = 16.sp,
                                        color = MaterialTheme.colorScheme.inverseOnSurface,
                                        fontFamily = FontFamily(
                                            language = coreState.language,
                                            weight = FontWeight.Medium
                                        )
                                    )
                                }
                                coreState.user?.let { user ->
                                    Text(
                                        text = user.email,
                                        fontSize = 14.sp,
                                        color = MaterialTheme.colorScheme.onTertiary,
                                        fontFamily = FontFamily(
                                            language = coreState.language,
                                            weight = FontWeight.Normal
                                        )
                                    )
                                }
                                HorizontalDivider()
                            }
                        },
                        contentPadding = PaddingValues(horizontal = 6.dp)
                    )
                    DropdownMenuItem(
                        modifier = Modifier.padding(horizontal = 4.dp).padding(top = 4.dp)
                            .clip(RoundedCornerShape(6.dp)),
                        onClick = {},
                        text = {
                            Text(
                                text = stringResource(Res.string.Profile),
                                fontSize = 16.sp,
                                color = MaterialTheme.colorScheme.inverseOnSurface,
                                fontFamily = FontFamily(
                                    language = coreState.language,
                                    weight = FontWeight.Medium
                                )
                            )
                        },
                        leadingIcon = {
                            Icon(
                                imageVector = Lucide.UserRoundPen,
                                contentDescription = "Profile",
                                tint = MaterialTheme.colorScheme.inverseOnSurface
                            )
                        },
                        contentPadding = PaddingValues(horizontal = 6.dp)
                    )
                    DropdownMenuItem(
                        modifier = Modifier.padding(horizontal = 4.dp).padding(bottom = 4.dp)
                            .clip(RoundedCornerShape(6.dp)),
                        onClick = {},
                        text = {
                            Text(
                                text = stringResource(Res.string.Help),
                                fontSize = 16.sp,
                                color = MaterialTheme.colorScheme.inverseOnSurface,
                                fontFamily = FontFamily(
                                    language = coreState.language,
                                    weight = FontWeight.Medium
                                )
                            )
                        },
                        leadingIcon = {
                            Icon(
                                imageVector = Lucide.CircleHelp,
                                contentDescription = "Help",
                                tint = MaterialTheme.colorScheme.inverseOnSurface
                            )
                        },
                        contentPadding = PaddingValues(horizontal = 6.dp)
                    )
                    HorizontalDivider(modifier = Modifier.fillMaxWidth())
                    DropdownMenuItem(
                        modifier = Modifier.padding(horizontal = 4.dp).padding(top = 4.dp)
                            .clip(RoundedCornerShape(6.dp))
                            .background(MaterialTheme.colorScheme.error.copy(alpha = 0.25f)),
                        onClick = {
                            coroutineScope.launch {
                                onAction(DashboardAction.OnProfileMenuToggle)
                            }
                            onLogout()
                        },
                        contentPadding = PaddingValues(vertical = 4.dp, horizontal = 6.dp),
                        text = {
                            Text(
                                text = stringResource(Res.string.Logout),
                                fontSize = 16.sp,
                                color = MaterialTheme.colorScheme.error,
                                fontFamily = FontFamily(
                                    language = coreState.language,
                                    weight = FontWeight.Medium
                                )
                            )
                        },
                        leadingIcon = {
                            Icon(
                                imageVector = Lucide.LogOut,
                                contentDescription = "Logout",
                                tint = MaterialTheme.colorScheme.error
                            )
                        },
                    )
                }
            }
        }
    }
}