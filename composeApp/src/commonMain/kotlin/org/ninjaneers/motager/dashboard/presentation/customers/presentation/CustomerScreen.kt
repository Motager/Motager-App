package org.ninjaneers.motager.dashboard.presentation.customers.presentation

import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import motager.composeapp.generated.resources.Add
import motager.composeapp.generated.resources.Customers
import motager.composeapp.generated.resources.Res
import motager.composeapp.generated.resources.Search
import motager.composeapp.generated.resources.hellipsis
import motager.composeapp.generated.resources.switch
import motager.composeapp.generated.resources.user_plus
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.ninjaneers.motager.core.presentation.CoreState
import org.ninjaneers.motager.core.presentation.components.PrimaryButton
import org.ninjaneers.motager.core.presentation.components.PrimaryIconButton
import org.ninjaneers.motager.core.presentation.components.PrimaryTextField
import org.ninjaneers.motager.core.presentation.theme.FontFamily
import org.ninjaneers.motager.dashboard.presentation.components.Pagination
import org.ninjaneers.motager.dashboard.presentation.components.Table
import org.ninjaneers.motager.dashboard.presentation.components.TableActionCell
import org.ninjaneers.motager.dashboard.presentation.components.TableCell
import org.ninjaneers.motager.dashboard.presentation.components.TableHeader
import org.ninjaneers.motager.dashboard.presentation.components.TableRow
import org.ninjaneers.motager.dashboard.presentation.customers.presentation.components.CustomerDialog

@Composable
fun CustomersScreen(
    state: CustomerScreenState,
    coreState: CoreState,
    onAction: (CustomerAction) -> Unit,
) {

    CustomerScreenContent(
        state = state,
        coreState = coreState,
        onAction = onAction
    )
}

@Composable
private fun CustomerScreenContent(
    state: CustomerScreenState,
    coreState: CoreState,
    onAction: (CustomerAction) -> Unit
) {
    if (state.isCustomerDialogVisible) {
        CustomerDialog(
            coreState = coreState,
            state = state,
            onAction = onAction
        )
    }
    LaunchedEffect(Unit) {
        onAction(CustomerAction.OnCustomersGet(coreState.store.id))
    }
    Column(
        modifier = Modifier
            .clip(RoundedCornerShape(6.dp))
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.secondary.copy(alpha = 0.5f))
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        )
        {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            )
            {
                Text(
                    modifier = Modifier.weight(1f),
                    text = stringResource(Res.string.Customers),
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
                            onAction(CustomerAction.OnCustomerDialogToggleVisibility)
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
                                painter = painterResource(Res.drawable.user_plus),
                                contentDescription = "more",
                            )
                            Text(
                                text = stringResource(Res.string.Add),
                                color = MaterialTheme.colorScheme.onPrimary,
                                fontSize = 14.sp,
                                fontFamily = FontFamily(
                                    weight = FontWeight.Medium,
                                    language = coreState.language
                                ),
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
                    (false && state.isError == null) -> {
                        Column(
                            modifier = Modifier.fillMaxWidth(),
                            verticalArrangement = Arrangement.spacedBy(8.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Row(
                                modifier = Modifier
                                    .height(40.dp)
                                    .fillMaxWidth(),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(8.dp)
                            ) {
                                PrimaryTextField(
                                    value = state.searchQuery,
                                    onValueChange = {
                                        onAction(CustomerAction.OnCustomerSearch(it))
                                    },
                                    modifier = Modifier.fillMaxWidth()
                                        .weight(1F),
                                    placeholder = {
                                        Text(
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
                                        .weight(1f)
                                        .border(
                                            width = 1.5f.dp,
                                            color = MaterialTheme.colorScheme.outline,
                                            shape = RoundedCornerShape(6.dp)
                                        )
                                ) {
                                    Table(
                                        items = state.filteredCustomers,
                                        header = {
                                            TableHeader(
                                                headers = state.tableHeaders
                                            )
                                        }
                                    )
                                    { customer ->
                                        TableRow {
                                            TableCell(customer.email)
                                            TableCell(customer.totalPayment.toString())
                                            TableActionCell()
                                        }
                                    }
                                }
                                Pagination(
                                    language = coreState.language,
                                    resultsCount = state.customers.size
                                )
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
                            CircularProgressIndicator(
                                modifier = Modifier.size(60.dp),
                                trackColor = MaterialTheme.colorScheme.primary
                            )
                        }
                    }
                    else -> {}
                }
            }
        }
    }
}