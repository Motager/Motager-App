package org.ninjaneers.motager.dashboard.presentation.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch
import motager.composeapp.generated.resources.Arabic
import motager.composeapp.generated.resources.Dark
import motager.composeapp.generated.resources.DashboardLinks
import motager.composeapp.generated.resources.English
import motager.composeapp.generated.resources.Light
import motager.composeapp.generated.resources.Logout
import motager.composeapp.generated.resources.OutfitMedium
import motager.composeapp.generated.resources.OutfitRegular
import motager.composeapp.generated.resources.OutfitSemiBold
import motager.composeapp.generated.resources.Res
import motager.composeapp.generated.resources.Support
import motager.composeapp.generated.resources.System
import motager.composeapp.generated.resources.ar
import motager.composeapp.generated.resources.en
import motager.composeapp.generated.resources.headset
import motager.composeapp.generated.resources.languages
import motager.composeapp.generated.resources.log_out
import motager.composeapp.generated.resources.moon
import motager.composeapp.generated.resources.plan_img
import motager.composeapp.generated.resources.sun
import motager.composeapp.generated.resources.system
import org.jetbrains.compose.resources.Font
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.ninjaneers.motager.core.domain.Language
import org.ninjaneers.motager.core.domain.Theme
import org.ninjaneers.motager.core.presentation.CoreAction
import org.ninjaneers.motager.core.presentation.components.PrimaryIconButton
import org.ninjaneers.motager.dashboard.domain.NavDrawerItem
import org.ninjaneers.motager.dashboard.presentation.DashboardAction
import org.ninjaneers.motager.dashboard.presentation.DashboardState

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun NavDrawer(
    state: DashboardState,
    items: List<NavDrawerItem>,
    onAction: suspend (DashboardAction) -> Unit,
    coreAction: (CoreAction) -> Unit,
) {
    val coroutineScope = rememberCoroutineScope()
    ModalDrawerSheet(
        modifier = Modifier
            .windowInsetsPadding(WindowInsets.statusBars)
            .width(280.dp).border(
                width = 0.8f.dp,
                color = MaterialTheme.colorScheme.outline,
                shape = RoundedCornerShape(topEnd = 6.dp, bottomEnd = 6.dp)
            ),
        drawerContainerColor = MaterialTheme.colorScheme.background,
        drawerShape = RoundedCornerShape(topEnd = 6.dp, bottomEnd = 6.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .padding(8.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            LazyColumn {
                item {
                    NavDrawerHeader()
                }
                stickyHeader {
                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(MaterialTheme.colorScheme.background),
                        text = stringResource(Res.string.DashboardLinks),
                        fontSize = 14.sp,
                        color = MaterialTheme.colorScheme.onTertiary,
                        fontFamily = FontFamily(
                            Font(
                                resource = Res.font.OutfitRegular,
                                weight = FontWeight.Normal
                            )
                        ),
                    )
                }
                items(items.size, key = { it }) { index ->
                    NavigationDrawerItem(
                        selected = state.selectedIndex == index,
                        onClick = {
                            coroutineScope.launch {
                                onAction(DashboardAction.CloseNavigationDrawer)
                                onAction(
                                    DashboardAction.OnContentChange(
                                        items[index].content,
                                        index
                                    )
                                )
                            }
                        },
                        label = {
                            Text(
                                text = stringResource(items[index].label),
                                color = MaterialTheme.colorScheme.onBackground,
                                fontSize = 18.sp,
                                fontFamily = FontFamily(
                                    Font(
                                        resource = if (index == state.selectedIndex) Res.font.OutfitSemiBold else Res.font.OutfitMedium,
                                        weight = if (index == state.selectedIndex) FontWeight.SemiBold else FontWeight.Medium
                                    )
                                )
                            )
                        },
                        icon = {
                            Icon(
                                painter = painterResource(items[index].icon),
                                contentDescription = null,
                            )
                        },
                        shape = RoundedCornerShape(16.dp),
                        colors = NavigationDrawerItemDefaults.colors(
                            selectedContainerColor = MaterialTheme.colorScheme.onTertiary.copy(
                                alpha = 0.12f
                            ),
                            selectedIconColor = MaterialTheme.colorScheme.primary,
                            unselectedIconColor = MaterialTheme.colorScheme.onBackground
                        ),
                    )
                }
                item {
                    Box(
                        contentAlignment = Alignment.TopCenter
                    ) {
                        Column(
                            modifier = Modifier
                                .padding(top = 65.dp)
                                .clip(RoundedCornerShape(6.dp))
                                .background(MaterialTheme.colorScheme.primary.copy(alpha = 0.15f)),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            Text(
                                modifier = Modifier.padding(top = 55.dp),
                                text = "Starter Plan",
                                fontSize = 20.sp,
                                fontFamily = FontFamily(
                                    Font(
                                        resource = Res.font.OutfitSemiBold,
                                        weight = FontWeight.SemiBold
                                    )
                                ),
                                color = MaterialTheme.colorScheme.onBackground,
                                textAlign = TextAlign.Center
                            )
                            Text(
                                modifier = Modifier.padding(
                                    top = 8.dp,
                                    end = 8.dp,
                                    start = 8.dp,
                                    bottom = 12.dp
                                ),
                                text = "Upgrade your plan to get the full power!",
                                fontSize = 18.sp,
                                fontFamily = FontFamily(
                                    Font(
                                        resource = Res.font.OutfitRegular,
                                        weight = FontWeight.Normal
                                    )
                                ),
                                color = MaterialTheme.colorScheme.onTertiary,
                                textAlign = TextAlign.Center
                            )

                        }
                        Image(
                            modifier = Modifier.size(120.dp),
                            painter = painterResource(Res.drawable.plan_img),
                            contentDescription = "Plan"
                        )
                    }
                }
                item {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Box {
                            PrimaryIconButton(
                                onClick = {
                                    coroutineScope.launch {
                                        onAction(
                                            DashboardAction.OnThemeMenuToggle(
                                                state.isThemeMenuExpanded
                                            )
                                        )
                                    }
                                },
                                painter = painterResource(Res.drawable.moon),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = MaterialTheme.colorScheme.background,
                                    contentColor = MaterialTheme.colorScheme.surfaceContainerLowest
                                ),
                                language = Language.English
                            )
                            DropdownMenu(
                                expanded = false,
                                onDismissRequest = {
                                    coroutineScope.launch {
                                        onAction(
                                            DashboardAction.OnThemeMenuToggle(
                                                state.isThemeMenuExpanded
                                            )
                                        )
                                    }
                                },
                                border = BorderStroke(
                                    width = 0.8f.dp,
                                    color = MaterialTheme.colorScheme.outline
                                ),
                                offset = DpOffset((-5).dp, (-5).dp),
                                shape = RoundedCornerShape(6.dp),
                                containerColor = MaterialTheme.colorScheme.inverseSurface
                            ) {
                                DropdownMenuItem(
                                    modifier = Modifier.padding(horizontal = 6.dp)
                                        .clip(RoundedCornerShape(6.dp)),
                                    onClick = {
                                        coroutineScope.launch {
                                            onAction(
                                                DashboardAction.OnThemeMenuToggle(
                                                    state.isThemeMenuExpanded
                                                )
                                            )
                                        }
                                        coreAction(CoreAction.ChangeTheme(Theme.Light))
                                    },
                                    text = {
                                        Text(
                                            text = stringResource(Res.string.Light),
                                            fontSize = 14.sp,
                                            color = MaterialTheme.colorScheme.inverseOnSurface,
                                            fontFamily = FontFamily(
                                                Font(
                                                    resource = Res.font.OutfitRegular,
                                                    weight = FontWeight.Normal
                                                )
                                            ),
                                            textAlign = TextAlign.Center
                                        )
                                    },
                                    leadingIcon = {
                                        Icon(
                                            painter = painterResource(Res.drawable.sun),
                                            contentDescription = "Light mode",
                                            tint = MaterialTheme.colorScheme.inverseOnSurface
                                        )
                                    },
                                    contentPadding = PaddingValues(horizontal = 12.dp)
                                )
                                DropdownMenuItem(
                                    modifier = Modifier.padding(horizontal = 6.dp)
                                        .clip(RoundedCornerShape(6.dp)),
                                    onClick = {
                                        coroutineScope.launch {
                                            onAction(
                                                DashboardAction.OnThemeMenuToggle(
                                                    state.isThemeMenuExpanded
                                                )
                                            )
                                        }
                                        coreAction(CoreAction.ChangeTheme(Theme.Dark))
                                    },
                                    text = {
                                        Text(
                                            text = stringResource(Res.string.Dark),
                                            fontSize = 14.sp,
                                            color = MaterialTheme.colorScheme.inverseOnSurface,
                                            fontFamily = FontFamily(
                                                Font(
                                                    resource = Res.font.OutfitRegular,
                                                    weight = FontWeight.Normal
                                                )
                                            ),
                                            textAlign = TextAlign.Center
                                        )
                                    },
                                    leadingIcon = {
                                        Icon(
                                            painter = painterResource(Res.drawable.moon),
                                            contentDescription = "Dark mode",
                                            tint = MaterialTheme.colorScheme.inverseOnSurface
                                        )
                                    },
                                    contentPadding = PaddingValues(horizontal = 12.dp)
                                )
                                DropdownMenuItem(
                                    modifier = Modifier.padding(horizontal = 6.dp)
                                        .clip(RoundedCornerShape(6.dp)),
                                    onClick = {
                                        coroutineScope.launch {
                                            onAction(
                                                DashboardAction.OnThemeMenuToggle(
                                                    state.isThemeMenuExpanded
                                                )
                                            )
                                        }
                                        coreAction(CoreAction.ChangeTheme(Theme.System))
                                    },
                                    text = {
                                        Text(
                                            text = stringResource(Res.string.System),
                                            fontSize = 14.sp,
                                            color = MaterialTheme.colorScheme.inverseOnSurface,
                                            fontFamily = FontFamily(
                                                Font(
                                                    resource = Res.font.OutfitRegular,
                                                    weight = FontWeight.Normal
                                                )
                                            ),
                                            textAlign = TextAlign.Center
                                        )
                                    },
                                    leadingIcon = {
                                        Icon(
                                            painter = painterResource(Res.drawable.system),
                                            contentDescription = "System theme",
                                            tint = MaterialTheme.colorScheme.inverseOnSurface
                                        )
                                    },
                                    contentPadding = PaddingValues(horizontal = 12.dp)
                                )
                            }
                        }
                        Box {
                            PrimaryIconButton(
                                onClick = {
                                    coroutineScope.launch {
                                        onAction(
                                            DashboardAction.OnLocaleMenuToggle(
                                                state.isLocaleMenuExpanded
                                            )
                                        )
                                    }
                                },
                                painter = painterResource(Res.drawable.languages),
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = MaterialTheme.colorScheme.background,
                                    contentColor = MaterialTheme.colorScheme.surfaceContainerLowest
                                ),
                                language = Language.English
                            )
                            DropdownMenu(
                                expanded = false,
                                onDismissRequest = {
                                    coroutineScope.launch {
                                        onAction(
                                            DashboardAction.OnLocaleMenuToggle(
                                                state.isLocaleMenuExpanded
                                            )
                                        )
                                    }
                                },
                                border = BorderStroke(
                                    width = 0.8f.dp,
                                    color = MaterialTheme.colorScheme.outline
                                ),
                                offset = DpOffset((-35).dp, (-5).dp),
                                shape = RoundedCornerShape(6.dp),
                                containerColor = MaterialTheme.colorScheme.inverseSurface
                            ) {
                                DropdownMenuItem(
                                    modifier = Modifier.padding(horizontal = 6.dp)
                                        .clip(RoundedCornerShape(6.dp)),
                                    onClick = {
                                        coroutineScope.launch {
                                            onAction(
                                                DashboardAction.OnLocaleMenuToggle(
                                                    state.isLocaleMenuExpanded
                                                )
                                            )
                                        }
                                        coreAction(CoreAction.ChangeLanguage(Language.Arabic))
                                    },
                                    text = {
                                        Text(
                                            text = stringResource(Res.string.Arabic),
                                            fontSize = 14.sp,
                                            color = MaterialTheme.colorScheme.inverseOnSurface,
                                            fontFamily = FontFamily(
                                                Font(
                                                    resource = Res.font.OutfitRegular,
                                                    weight = FontWeight.Normal
                                                )
                                            ),
                                            textAlign = TextAlign.Center
                                        )
                                    },
                                    leadingIcon = {
                                        Icon(
                                            painter = painterResource(Res.drawable.ar),
                                            contentDescription = "Arabic Language",
                                            tint = Color.Unspecified
                                        )
                                    },
                                    contentPadding = PaddingValues(horizontal = 12.dp)
                                )
                                DropdownMenuItem(
                                    modifier = Modifier.padding(horizontal = 6.dp)
                                        .clip(RoundedCornerShape(6.dp)),
                                    onClick = {
                                        coroutineScope.launch {
                                            onAction(
                                                DashboardAction.OnLocaleMenuToggle(
                                                    state.isLocaleMenuExpanded
                                                )
                                            )
                                        }
                                        coreAction(CoreAction.ChangeLanguage(Language.English))
                                    },
                                    text = {
                                        Text(
                                            text = stringResource(Res.string.English),
                                            fontSize = 14.sp,
                                            color = MaterialTheme.colorScheme.inverseOnSurface,
                                            fontFamily = FontFamily(
                                                Font(
                                                    resource = Res.font.OutfitRegular,
                                                    weight = FontWeight.Normal
                                                )
                                            ),
                                            textAlign = TextAlign.Center
                                        )
                                    },
                                    leadingIcon = {
                                        Icon(
                                            painter = painterResource(Res.drawable.en),
                                            contentDescription = "English Language",
                                            tint = Color.Unspecified
                                        )
                                    },
                                    contentPadding = PaddingValues(horizontal = 12.dp)
                                )
                            }
                        }
                        Button(
                            modifier = Modifier.weight(1f),
                            onClick = {},
                            shape = RoundedCornerShape(6.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = MaterialTheme.colorScheme.background,
                                contentColor = MaterialTheme.colorScheme.surfaceContainerLowest
                            ),
                            border = BorderStroke(
                                width = 0.8.dp,
                                color = MaterialTheme.colorScheme.outline
                            )
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.Center
                            ) {
                                Icon(
                                    modifier = Modifier.padding(end = 8.dp),
                                    painter = painterResource(Res.drawable.headset),
                                    contentDescription = "support"
                                )
                                Text(
                                    text = stringResource(Res.string.Support),
                                    fontSize = 18.sp,
                                    fontFamily = FontFamily(
                                        Font(
                                            resource = Res.font.OutfitMedium,
                                            weight = FontWeight.Medium
                                        )
                                    )
                                )
                            }
                        }
                    }
                }
                item {
                    Button(
                        modifier = Modifier.fillMaxWidth().height(40.dp),
                        onClick = {},
                        shape = RoundedCornerShape(6.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = MaterialTheme.colorScheme.error.copy(alpha = 0.3f),
                            contentColor = MaterialTheme.colorScheme.surfaceContainerLowest
                        )
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center
                        ) {
                            Icon(
                                modifier = Modifier.size(28.dp).padding(end = 8.dp),
                                painter = painterResource(Res.drawable.log_out),
                                contentDescription = "support",
                                tint = MaterialTheme.colorScheme.error
                            )
                            Text(
                                text = stringResource(Res.string.Logout),
                                fontSize = 20.sp,
                                fontFamily = FontFamily(
                                    Font(
                                        resource = Res.font.OutfitMedium,
                                        weight = FontWeight.Medium
                                    )
                                ),
                                color = MaterialTheme.colorScheme.error
                            )
                        }
                    }
                }
            }
        }
    }
}