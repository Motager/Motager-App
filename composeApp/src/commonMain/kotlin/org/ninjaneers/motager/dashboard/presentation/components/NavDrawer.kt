package org.ninjaneers.motager.dashboard.presentation.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import kotlinx.coroutines.launch
import motager.composeapp.generated.resources.Arabic
import motager.composeapp.generated.resources.Dark
import motager.composeapp.generated.resources.DashboardLinks
import motager.composeapp.generated.resources.English
import motager.composeapp.generated.resources.Light
import motager.composeapp.generated.resources.Res
import motager.composeapp.generated.resources.Support
import motager.composeapp.generated.resources.System
import motager.composeapp.generated.resources.ar
import motager.composeapp.generated.resources.en
import motager.composeapp.generated.resources.headset
import motager.composeapp.generated.resources.languages
import motager.composeapp.generated.resources.moon
import motager.composeapp.generated.resources.store
import motager.composeapp.generated.resources.sun
import motager.composeapp.generated.resources.system
import motager.composeapp.generated.resources.up_down_chevron
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.ninjaneers.motager.core.domain.Language
import org.ninjaneers.motager.core.domain.Theme
import org.ninjaneers.motager.core.presentation.CoreAction
import org.ninjaneers.motager.core.presentation.components.PrimaryIconButton
import org.ninjaneers.motager.core.presentation.components.SecondaryButton
import org.ninjaneers.motager.core.presentation.theme.FontFamily
import org.ninjaneers.motager.dashboard.domain.NavDrawerItem
import org.ninjaneers.motager.dashboard.presentation.DashboardAction
import org.ninjaneers.motager.dashboard.presentation.DashboardState

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun NavDrawer(
    state: DashboardState,
    onAction: suspend (DashboardAction) -> Unit,
    coreAction: (CoreAction) -> Unit,
    items: List<NavDrawerItem>,
    language: Language,
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
        LazyColumn(
            modifier = Modifier
                .fillMaxHeight()
                .padding(8.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            stickyHeader {
                SecondaryButton(
                    modifier = Modifier.height(42.dp),
                    onClick = {},
                    border = BorderStroke(width = 1f.dp, color = MaterialTheme.colorScheme.primary)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp, horizontal = 16.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(8.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                modifier = Modifier.size(16.dp),
                                painter = painterResource(Res.drawable.store),
                                contentDescription = "Store",
                                tint = MaterialTheme.colorScheme.onBackground
                            )
                            Text(
                                text = "Store Name",
                                fontSize = 18.sp,
                                fontFamily = FontFamily(
                                    weight = FontWeight.Medium,
                                    language = Language.English
                                ),
                                color = MaterialTheme.colorScheme.onBackground
                            )
                        }
                        Icon(
                            painter = painterResource(Res.drawable.up_down_chevron),
                            contentDescription = "expand",
                            tint = MaterialTheme.colorScheme.onTertiary
                        )
                    }
                }
            }
            item {
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(MaterialTheme.colorScheme.background),
                    text = stringResource(Res.string.DashboardLinks),
                    fontSize = 14.sp,
                    color = MaterialTheme.colorScheme.onTertiary,
                    fontFamily = FontFamily(
                        weight = FontWeight.Normal,
                        language = language
                    )
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
                                weight = if (index == state.selectedIndex) FontWeight.SemiBold else FontWeight.Medium,
                                language = language
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
                                weight = FontWeight.SemiBold,
                                language = language
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
                                weight = FontWeight.Normal,
                                language = language
                            ),
                            color = MaterialTheme.colorScheme.onTertiary,
                            textAlign = TextAlign.Center
                        )

                    }
                    AsyncImage(
                        modifier = Modifier.size(120.dp),
                        model = "https://motager.vercel.app/_next/image?url=%2Fimages%2Fpro.png&w=256&q=75",
                        contentDescription = "Plan"
                    )
                }
            }
            item {
                Row(
                    modifier = Modifier.fillMaxWidth().padding(top = 8.dp),
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
                            expanded = state.isThemeMenuExpanded,
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
                                    coreAction(CoreAction.OnThemeChange(Theme.Light))
                                },
                                text = {
                                    Text(
                                        text = stringResource(Res.string.Light),
                                        fontSize = 14.sp,
                                        color = MaterialTheme.colorScheme.inverseOnSurface,
                                        fontFamily = FontFamily(
                                            weight = FontWeight.Normal,
                                            language = language
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
                                    coreAction(CoreAction.OnThemeChange(Theme.Dark))
                                },
                                text = {
                                    Text(
                                        text = stringResource(Res.string.Dark),
                                        fontSize = 14.sp,
                                        color = MaterialTheme.colorScheme.inverseOnSurface,
                                        fontFamily = FontFamily(
                                            weight = FontWeight.Normal,
                                            language = language
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
                                    coreAction(CoreAction.OnThemeChange(Theme.System))
                                },
                                text = {
                                    Text(
                                        text = stringResource(Res.string.System),
                                        fontSize = 14.sp,
                                        color = MaterialTheme.colorScheme.inverseOnSurface,
                                        fontFamily = FontFamily(
                                            weight = FontWeight.Normal,
                                            language = language
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
                            expanded = state.isLocaleMenuExpanded,
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
                                    coreAction(CoreAction.OnLanguageChange(Language.Arabic))
                                },
                                text = {
                                    Text(
                                        text = stringResource(Res.string.Arabic),
                                        fontSize = 14.sp,
                                        color = MaterialTheme.colorScheme.inverseOnSurface,
                                        fontFamily = FontFamily(
                                            weight = FontWeight.Normal,
                                            language = language
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
                                    coreAction(CoreAction.OnLanguageChange(Language.English))
                                },
                                text = {
                                    Text(
                                        text = stringResource(Res.string.English),
                                        fontSize = 14.sp,
                                        color = MaterialTheme.colorScheme.inverseOnSurface,
                                        fontFamily = FontFamily(
                                            weight = FontWeight.Normal,
                                            language = language
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
                        modifier = Modifier.weight(1f).height(40.dp),
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
                                    weight = FontWeight.Medium,
                                    language = language
                                ),
                            )
                        }
                    }
                }
            }
        }
    }
}
