package org.ninjaneers.motager.dashboard.presentation.orders.presentation

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import motager.composeapp.generated.resources.Create
import motager.composeapp.generated.resources.Next
import motager.composeapp.generated.resources.Of
import motager.composeapp.generated.resources.Orders
import motager.composeapp.generated.resources.OutfitBold
import motager.composeapp.generated.resources.OutfitMedium
import motager.composeapp.generated.resources.OutfitRegular
import motager.composeapp.generated.resources.Page
import motager.composeapp.generated.resources.Prev
import motager.composeapp.generated.resources.Res
import motager.composeapp.generated.resources.Results
import motager.composeapp.generated.resources.Search
import motager.composeapp.generated.resources.chevronleft
import motager.composeapp.generated.resources.chevronright
import motager.composeapp.generated.resources.filebox
import motager.composeapp.generated.resources.hellipsis
import motager.composeapp.generated.resources.switch
import org.jetbrains.compose.resources.Font
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.ninjaneers.motager.app.navigation.Navigator
import org.ninjaneers.motager.core.presentation.components.PrimaryButton
import org.ninjaneers.motager.core.presentation.components.PrimaryIconButton
import org.ninjaneers.motager.core.presentation.components.PrimaryTextField
import org.ninjaneers.motager.dashboard.presentation.DashboardAction
import org.ninjaneers.motager.dashboard.presentation.DashboardState
import org.ninjaneers.motager.dashboard.presentation.components.NavDrawer
import org.ninjaneers.motager.dashboard.presentation.components.Table
import org.ninjaneers.motager.dashboard.presentation.components.TableActionCell
import org.ninjaneers.motager.dashboard.presentation.components.TableCell
import org.ninjaneers.motager.dashboard.presentation.components.TableHeader
import org.ninjaneers.motager.dashboard.presentation.components.TableRow
import org.ninjaneers.motager.dashboard.presentation.components.TableStatusCell
import org.ninjaneers.motager.dashboard.presentation.components.TopBar

@Composable
fun OrdersScreen(
    state: OrdersScreenState,
    navigator: Navigator,
    dashboardState: DashboardState,
    onAction: suspend (DashboardAction) -> Unit

) {
    OrdersScreenContent(
        state = state,
        navigator = navigator,
        dashboardState = dashboardState,
        onAction = onAction
    )
}

@Composable
private fun OrdersScreenContent(
    state: OrdersScreenState,
    navigator: Navigator,
    dashboardState: DashboardState,
    onAction: suspend (DashboardAction) -> Unit
) {
    ModalNavigationDrawer(
        drawerContent = {
            NavDrawer(
                navigator = navigator,
                navigationItems = dashboardState.navigationItems,
                closeDrawer = onAction
            )
        },
        drawerState = dashboardState.drawerState,
        scrimColor = MaterialTheme.colorScheme.background.copy(alpha = 0.5f)
    ) {
        Scaffold(
            topBar = {
                TopBar(
                    openNavDrawer = onAction
                )
            }
        ) { innerPadding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colorScheme.background)
                    .padding(innerPadding)
                    .padding(8.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
//                AnimatedVisibility(
//                    visible = true,
//                    enter = slideInVertically(
//                        animationSpec = spring(
//                            dampingRatio = Spring.DampingRatioMediumBouncy,
//                            stiffness = Spring.StiffnessMediumLow
//                        )
//                    ),
//                ) {
                Column(
                    modifier = Modifier
                        .clip(RoundedCornerShape(6.dp))
                        .fillMaxSize()
                        .background(MaterialTheme.colorScheme.secondary.copy(alpha = 0.5f))
                        .padding(8.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        verticalArrangement = Arrangement.spacedBy(8.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                modifier = Modifier.weight(1f),
                                text = stringResource(Res.string.Orders),
                                fontFamily = FontFamily(
                                    Font(
                                        resource = Res.font.OutfitMedium,
                                        weight = FontWeight.Medium
                                    )
                                ),
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis,
                                color = MaterialTheme.colorScheme.onBackground,
                                fontSize = 30.sp,
                                textAlign = TextAlign.Start
                            )
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(8.dp)
                            ) {
                                PrimaryIconButton(
                                    onClick = {},
                                    painter = painterResource(Res.drawable.hellipsis),
                                    colors = ButtonDefaults.buttonColors(
                                        containerColor = MaterialTheme.colorScheme.secondary,
                                        contentColor = MaterialTheme.colorScheme.surfaceContainerLowest
                                    )
                                )
                                PrimaryButton(
                                    modifier = Modifier
                                        .height(42.dp)
                                        .wrapContentWidth(),
                                    onClick = {},
                                    contentPadding = PaddingValues(
                                        horizontal = 16.dp,
                                        vertical = 8.dp
                                    ),
                                    shape = RoundedCornerShape(6.dp)
                                ) {
                                    Row(
                                        verticalAlignment = Alignment.CenterVertically,
                                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                                    ) {
                                        Icon(
                                            painter = painterResource(Res.drawable.filebox),
                                            contentDescription = "more",
                                            tint = MaterialTheme.colorScheme.onPrimary
                                        )
                                        Text(
                                            text = stringResource(Res.string.Create),
                                            color = MaterialTheme.colorScheme.onPrimary,
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
                        HorizontalDivider(
                            modifier = Modifier
                                .clip(RoundedCornerShape(100.dp)),
                            thickness = 2.dp,
                            color = MaterialTheme.colorScheme.outline,
                        )
                    }
                    Row(
                        modifier = Modifier
                            .height(40.dp)
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        PrimaryTextField(
                            value = "",
                            onValueChange = {},
                            modifier = Modifier
                                .fillMaxHeight()
                                .weight(1f),
                            placeholder = {
                                Text(
                                    modifier = Modifier.padding(horizontal = 2.dp),
                                    text = stringResource(Res.string.Search),
                                    fontFamily = FontFamily(
                                        Font(
                                            resource = Res.font.OutfitRegular,
                                            weight = FontWeight.Normal
                                        )
                                    ),
                                    color = MaterialTheme.colorScheme.surfaceVariant,
                                    textAlign = TextAlign.Start,
                                    fontSize = 14.sp
                                )
                            }
                        )
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(4.dp)
                        ) {
                            PrimaryTextField(
                                value = "",
                                onValueChange = {},
                                modifier = Modifier.size(40.dp),
                                placeholder = {
                                    Text(
                                        text = "10",
                                        fontFamily = FontFamily(
                                            Font(
                                                resource = Res.font.OutfitRegular,
                                                weight = FontWeight.Normal
                                            )
                                        ),
                                        color = MaterialTheme.colorScheme.surfaceVariant,
                                        textAlign = TextAlign.Start,
                                        fontSize = 14.sp
                                    )
                                }
                            )
                            PrimaryIconButton(
                                onClick = {},
                                painter = painterResource(Res.drawable.switch),
                                iconTint = MaterialTheme.colorScheme.onBackground,
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = MaterialTheme.colorScheme.background,
                                    contentColor = MaterialTheme.colorScheme.surfaceContainerLowest
                                )
                            )
                        }
                    }
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.SpaceBetween
                    ) {
                        Column(
                            modifier = Modifier
                                .clip(RoundedCornerShape(6.dp))
                                .weight(1f)
                                .border(
                                    width = 1.5f.dp,
                                    color = MaterialTheme.colorScheme.outline,
                                    shape = RoundedCornerShape(6.dp)
                                )
                        ) {
                            Table(
                                items = state.ordersList,
                                header = {
                                    TableHeader(state.tableHeaders)
                                },
                            ) { order ->
                                TableRow {
                                    TableCell(order.orderNumber)
                                    TableCell(order.customer)
                                    TableCell(order.total.toString())
                                    TableStatusCell(order.status)
                                    TableActionCell()
                                }
                            }
                        }
                        Row(
                            modifier = Modifier
                                .padding(top = 8.dp)
                                .height(38.dp)
                                .fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(8.dp)
                            ) {
                                Button(
                                    modifier = Modifier.fillMaxHeight(),
                                    onClick = {},
                                    contentPadding = PaddingValues(0.dp),
                                    shape = RoundedCornerShape(6.dp),
                                    border = BorderStroke(
                                        width = 1.dp,
                                        color = MaterialTheme.colorScheme.outline
                                    ),
                                    colors = ButtonDefaults.buttonColors(
                                        containerColor = MaterialTheme.colorScheme.background,
                                        contentColor = MaterialTheme.colorScheme.surfaceContainerLowest
                                    )
                                ) {
                                    Row(
                                        modifier = Modifier.fillMaxHeight(),
                                        verticalAlignment = Alignment.CenterVertically,
                                    ) {
                                        Icon(
                                            painter = painterResource(Res.drawable.chevronleft),
                                            contentDescription = stringResource(Res.string.Prev),
                                            tint = MaterialTheme.colorScheme.surfaceVariant
                                        )
                                        Text(
                                            text = stringResource(Res.string.Prev),
                                            fontFamily = FontFamily(
                                                Font(
                                                    resource = Res.font.OutfitRegular,
                                                    weight = FontWeight.Normal
                                                )
                                            ),
                                            fontSize = 14.sp,
                                            color = MaterialTheme.colorScheme.surfaceVariant
                                        )
                                    }
                                }
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.spacedBy(2.dp)
                                ) {
                                    Text(
                                        text = stringResource(Res.string.Page),
                                        fontFamily = FontFamily(
                                            Font(
                                                resource = Res.font.OutfitRegular,
                                                weight = FontWeight.Normal
                                            )
                                        ),
                                        fontSize = 14.sp,
                                        color = MaterialTheme.colorScheme.onBackground
                                    )
                                    Text(
                                        text = "1",
                                        fontFamily = FontFamily(
                                            Font(
                                                resource = Res.font.OutfitBold,
                                                weight = FontWeight.Bold
                                            )
                                        ),
                                        fontSize = 14.sp,
                                        color = MaterialTheme.colorScheme.primary
                                    )
                                    Text(
                                        text = stringResource(Res.string.Of) + " 2",
                                        fontFamily = FontFamily(
                                            Font(
                                                resource = Res.font.OutfitRegular,
                                                weight = FontWeight.Normal
                                            )
                                        ),
                                        fontSize = 14.sp,
                                        color = MaterialTheme.colorScheme.onBackground
                                    )
                                }
                                Button(
                                    modifier = Modifier.fillMaxHeight(),
                                    onClick = {},
                                    contentPadding = PaddingValues(0.dp),
                                    shape = RoundedCornerShape(6.dp),
                                    border = BorderStroke(
                                        width = 1.dp,
                                        color = MaterialTheme.colorScheme.outline
                                    ),
                                    colors = ButtonDefaults.buttonColors(
                                        containerColor = MaterialTheme.colorScheme.background,
                                        contentColor = MaterialTheme.colorScheme.surfaceContainerLowest
                                    )
                                ) {
                                    Row(
                                        modifier = Modifier.fillMaxHeight(),
                                        verticalAlignment = Alignment.CenterVertically,
                                    ) {
                                        Text(
                                            text = stringResource(Res.string.Next),
                                            fontFamily = FontFamily(
                                                Font(
                                                    resource = Res.font.OutfitRegular,
                                                    weight = FontWeight.Normal
                                                )
                                            ),
                                            fontSize = 14.sp,
                                            color = MaterialTheme.colorScheme.surfaceVariant
                                        )
                                        Icon(
                                            painter = painterResource(Res.drawable.chevronright),
                                            contentDescription = stringResource(Res.string.Prev),
                                            tint = MaterialTheme.colorScheme.surfaceVariant
                                        )
                                    }
                                }
                            }
                            Row(
                                modifier = Modifier.fillMaxHeight(),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = stringResource(Res.string.Results),
                                    fontFamily = FontFamily(
                                        Font(
                                            resource = Res.font.OutfitRegular,
                                            weight = FontWeight.Normal
                                        )
                                    ),
                                    fontSize = 14.sp,
                                    color = MaterialTheme.colorScheme.onBackground
                                )
                                Text(
                                    text = " 9",
                                    fontFamily = FontFamily(
                                        Font(
                                            resource = Res.font.OutfitBold,
                                            weight = FontWeight.Bold
                                        )
                                    ),
                                    fontSize = 14.sp,
                                    color = MaterialTheme.colorScheme.primary
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}
