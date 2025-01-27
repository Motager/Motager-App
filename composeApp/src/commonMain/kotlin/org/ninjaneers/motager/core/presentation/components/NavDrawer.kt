package org.ninjaneers.motager.core.presentation.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DrawerDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import motager.composeapp.generated.resources.Analytics
import motager.composeapp.generated.resources.Categories
import motager.composeapp.generated.resources.Collections
import motager.composeapp.generated.resources.Customers
import motager.composeapp.generated.resources.Dark
import motager.composeapp.generated.resources.DashboardLinks
import motager.composeapp.generated.resources.Discounts
import motager.composeapp.generated.resources.Home
import motager.composeapp.generated.resources.Light
import motager.composeapp.generated.resources.Logout
import motager.composeapp.generated.resources.Orders
import motager.composeapp.generated.resources.OutfitMedium
import motager.composeapp.generated.resources.OutfitRegular
import motager.composeapp.generated.resources.OutfitSemiBold
import motager.composeapp.generated.resources.Products
import motager.composeapp.generated.resources.Res
import motager.composeapp.generated.resources.Settings
import motager.composeapp.generated.resources.Support
import motager.composeapp.generated.resources.System
import motager.composeapp.generated.resources.boxes
import motager.composeapp.generated.resources.chart
import motager.composeapp.generated.resources.customers
import motager.composeapp.generated.resources.discounts
import motager.composeapp.generated.resources.grid_plus
import motager.composeapp.generated.resources.headset
import motager.composeapp.generated.resources.home
import motager.composeapp.generated.resources.languages
import motager.composeapp.generated.resources.log_out
import motager.composeapp.generated.resources.moon
import motager.composeapp.generated.resources.orders
import motager.composeapp.generated.resources.plan_img
import motager.composeapp.generated.resources.products
import motager.composeapp.generated.resources.settings
import motager.composeapp.generated.resources.sun
import motager.composeapp.generated.resources.system
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.Font
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun NavDrawer() {
    var isThemeMenuExpanded by remember { mutableStateOf(false) }
    var isLocalMenuExpanded by remember { mutableStateOf(false) }
    var selectedIndex by remember { mutableStateOf(0) }
    ModalDrawerSheet(
        modifier = Modifier.width(320.dp).border(
            width = 0.8f.dp,
            color = MaterialTheme.colorScheme.outline,
            shape = DrawerDefaults.shape
        ),
        drawerContainerColor = MaterialTheme.colorScheme.background,
    ) {
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .padding(8.dp)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                NavDrawerHeader()
                Column {
                    Text(
                        modifier = Modifier
                            .padding(vertical = 6.dp),
                        text = stringResource(Res.string.DashboardLinks),
                        fontSize = 18.sp,
                        color = MaterialTheme.colorScheme.onTertiary,
                        fontFamily = FontFamily(
                            Font(
                                resource = Res.font.OutfitMedium,
                                weight = FontWeight.Medium
                            )
                        ),
                    )
                    navigationItems.forEachIndexed { index, item ->
                        NavigationDrawerItem(
                            label = {
                                Text(
                                    text = stringResource(item.label),
                                    color = MaterialTheme.colorScheme.onBackground,
                                    fontSize = 18.sp,
                                    fontFamily = FontFamily(
                                        Font(
                                            resource = if (item.selected) Res.font.OutfitSemiBold else Res.font.OutfitMedium,
                                            weight = if (item.selected) FontWeight.SemiBold else FontWeight.Medium
                                        )
                                    )
                                )
                            },
                            selected = selectedIndex == index,
                            onClick = {
                                item.selected = !item.selected
                                selectedIndex = index
                            },
                            icon = {
                                Icon(
                                    painter = painterResource(item.icon),
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
                }
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
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
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Box {
                        PrimaryIconButton(
                            onClick = { isThemeMenuExpanded = !isThemeMenuExpanded },
                            painter = painterResource(Res.drawable.moon),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = MaterialTheme.colorScheme.background,
                                contentColor = MaterialTheme.colorScheme.surfaceContainerLowest
                            )
                        )
                        DropdownMenu(
                            expanded = isThemeMenuExpanded,
                            onDismissRequest = { isThemeMenuExpanded = !isThemeMenuExpanded },
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
                                onClick = { isThemeMenuExpanded = !isThemeMenuExpanded },
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
                                onClick = { isThemeMenuExpanded = !isThemeMenuExpanded },
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
                                    isThemeMenuExpanded = !isThemeMenuExpanded
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
                    PrimaryIconButton(
                        onClick = {},
                        painter = painterResource(Res.drawable.languages),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = MaterialTheme.colorScheme.background,
                            contentColor = MaterialTheme.colorScheme.surfaceContainerLowest
                        )
                    )
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

data class NavDrawerItem(
    val label: StringResource,
    var selected: Boolean,
    val icon: DrawableResource,
)

val navigationItems = listOf(
    NavDrawerItem(
        label = Res.string.Home,
        selected = true,
        icon = Res.drawable.home,
    ),
    NavDrawerItem(
        label = Res.string.Orders,
        selected = false,
        icon = Res.drawable.orders,
    ),
    NavDrawerItem(
        label = Res.string.Products,
        selected = false,
        icon = Res.drawable.products,
    ),
    NavDrawerItem(
        label = Res.string.Collections,
        selected = false,
        icon = Res.drawable.grid_plus,
    ),
    NavDrawerItem(
        label = Res.string.Categories,
        selected = false,
        icon = Res.drawable.boxes,
    ),
    NavDrawerItem(
        label = Res.string.Customers,
        selected = false,
        icon = Res.drawable.customers,
    ),
    NavDrawerItem(
        label = Res.string.Analytics,
        selected = false,
        icon = Res.drawable.chart,
    ),
    NavDrawerItem(
        label = Res.string.Discounts,
        selected = false,
        icon = Res.drawable.discounts,
    ),
    NavDrawerItem(
        label = Res.string.Settings,
        selected = false,
        icon = Res.drawable.settings,
    )
)
