package org.ninjaneers.motager.dashboard.presentation.products.presentation

import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch
import motager.composeapp.generated.resources.Add
import motager.composeapp.generated.resources.Empty
import motager.composeapp.generated.resources.Products
import motager.composeapp.generated.resources.Res
import motager.composeapp.generated.resources.Search
import motager.composeapp.generated.resources.Try_Again
import motager.composeapp.generated.resources.empty_cart
import motager.composeapp.generated.resources.error
import motager.composeapp.generated.resources.hellipsis
import motager.composeapp.generated.resources.package_plus
import motager.composeapp.generated.resources.switch
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.ninjaneers.motager.core.presentation.CoreState
import org.ninjaneers.motager.core.presentation.components.PrimaryButton
import org.ninjaneers.motager.core.presentation.components.PrimaryIconButton
import org.ninjaneers.motager.core.presentation.components.PrimaryTextField
import org.ninjaneers.motager.core.presentation.theme.FontFamily
import org.ninjaneers.motager.dashboard.domain.DashboardContent
import org.ninjaneers.motager.dashboard.presentation.DashboardAction
import org.ninjaneers.motager.dashboard.presentation.components.Table
import org.ninjaneers.motager.dashboard.presentation.components.TableActionCell
import org.ninjaneers.motager.dashboard.presentation.components.TableCell
import org.ninjaneers.motager.dashboard.presentation.components.TableHeader
import org.ninjaneers.motager.dashboard.presentation.components.TableImageCell
import org.ninjaneers.motager.dashboard.presentation.components.TableRow

@Composable
fun ProductsScreen(
    state: ProductsState,
    coreState: CoreState,
    onAction: (ProductsAction) -> Unit,
    dashboardAction: suspend (DashboardAction) -> Unit
) {

    ProductsScreenContent(
        state = state,
        coreState = coreState,
        onAction = onAction,
        dashboardAction = dashboardAction
    )
}

@Composable
private fun ProductsScreenContent(
    state: ProductsState,
    coreState: CoreState,
    onAction: (ProductsAction) -> Unit,
    dashboardAction: suspend (DashboardAction) -> Unit
) {
    val coroutineScope = rememberCoroutineScope()
    LaunchedEffect(Unit) {
        onAction(ProductsAction.OnProductsGet(coreState.store.id))
    }
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
                    text = stringResource(Res.string.Products),
                    fontFamily = FontFamily(
                        weight = FontWeight.Medium,
                        language = coreState.language
                    ),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    color = MaterialTheme.colorScheme.onBackground,
                    fontSize = 24.sp,
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
                        ),
                        language = coreState.language
                    )
                    PrimaryButton(
                        modifier = Modifier
                            .height(42.dp)
                            .wrapContentWidth(),
                        onClick = {
                            coroutineScope.launch {
                                dashboardAction(
                                    DashboardAction.OnContentChange(
                                        content = DashboardContent.AddProduct
                                    )
                                )
                            }
                        },
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
                                painter = painterResource(Res.drawable.package_plus),
                                contentDescription = "more",
                                tint = MaterialTheme.colorScheme.onPrimary
                            )
                            Text(
                                text = stringResource(Res.string.Add),
                                color = MaterialTheme.colorScheme.onPrimary,
                                fontSize = 14.sp,
                                fontFamily = FontFamily(
                                    weight = FontWeight.Medium,
                                    language = coreState.language
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
            AnimatedContent(
                targetState = state.isLoading
            ) { isLoading ->
                when (isLoading) {
                    false -> {
                        Column(
                            modifier = Modifier.fillMaxWidth(),
                            verticalArrangement = Arrangement.spacedBy(8.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            if (state.isError == null) {
                                if (state.products.isNotEmpty()) {
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
                                                        weight = FontWeight.Normal,
                                                        language = coreState.language
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
                                                            weight = FontWeight.Normal,
                                                            language = coreState.language
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
                                                ),
                                                language = coreState.language
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
                                                .fillMaxWidth()
                                                .border(
                                                    width = 1.5f.dp,
                                                    color = MaterialTheme.colorScheme.outline,
                                                    shape = RoundedCornerShape(6.dp)
                                                )
                                        ) {
                                            Table(
                                                items = state.products,
                                                header = {
                                                    TableHeader(state.tableHeaders)
                                                },
                                            ) { product ->
                                                TableRow {
                                                    TableImageCell(product.image)
                                                    TableCell(product.name)
                                                    TableCell(product.description)
                                                    TableCell(product.category)
                                                    TableCell(product.price.toString())
                                                    TableActionCell()
                                                }
                                            }
                                        }
                                    }
                                } else {
                                    Column(
                                        modifier = Modifier.fillMaxSize(),
                                        horizontalAlignment = Alignment.CenterHorizontally,
                                        verticalArrangement = Arrangement.Center
                                    ) {
                                        Image(
                                            modifier = Modifier.fillMaxWidth(0.9f).aspectRatio(1f)
                                                .padding(horizontal = 12.dp),
                                            painter = painterResource(Res.drawable.empty_cart),
                                            contentDescription = "Empty"
                                        )
                                        Text(
                                            text = stringResource(Res.string.Empty),
                                            fontSize = 20.sp,
                                            color = MaterialTheme.colorScheme.onBackground,
                                            fontFamily = FontFamily(
                                                weight = FontWeight.Medium,
                                                language = coreState.language
                                            )
                                        )
                                    }
                                }
                            } else {
                                Image(
                                    modifier = Modifier.fillMaxWidth().aspectRatio(1f)
                                        .padding(horizontal = 12.dp),
                                    painter = painterResource(Res.drawable.error),
                                    contentDescription = "Error"
                                )
                                Text(
                                    modifier = Modifier.padding(bottom = 8.dp),
                                    text = state.isError.asString(),
                                    color = MaterialTheme.colorScheme.onBackground,
                                    fontSize = 20.sp,
                                    fontFamily = FontFamily(
                                        weight = FontWeight.Medium,
                                        language = coreState.language
                                    ),
                                    textAlign = TextAlign.Center
                                )
                                PrimaryButton(
                                    onClick = {
                                        onAction(ProductsAction.OnProductsGet(coreState.store.id))
                                    },
                                    shape = RoundedCornerShape(6.dp)
                                ) {
                                    Text(
                                        text = stringResource(Res.string.Try_Again),
                                        fontSize = 18.sp,
                                        color = MaterialTheme.colorScheme.onPrimary,
                                        fontFamily = FontFamily(
                                            weight = FontWeight.Medium,
                                            language = coreState.language
                                        )
                                    )
                                }
                            }
                        }
                    }
                    true -> {
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .wrapContentWidth()
                                .padding(16.dp),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            CircularProgressIndicator()
                        }
                    }
                }
            }
        }
    }
}