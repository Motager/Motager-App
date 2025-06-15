package org.ninjaneers.motager.dashboard.presentation.products.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.composables.icons.lucide.Bot
import com.composables.icons.lucide.Lucide
import motager.composeapp.generated.resources.Compare_at_price
import motager.composeapp.generated.resources.Cost_per_item
import motager.composeapp.generated.resources.Margin
import motager.composeapp.generated.resources.Price
import motager.composeapp.generated.resources.Profit
import motager.composeapp.generated.resources.Res
import motager.composeapp.generated.resources.SKU_Management
import motager.composeapp.generated.resources.Stock
import org.jetbrains.compose.resources.stringResource
import org.ninjaneers.motager.core.presentation.CoreState
import org.ninjaneers.motager.core.presentation.components.PrimaryTextField
import org.ninjaneers.motager.core.presentation.theme.FontFamily
import org.ninjaneers.motager.dashboard.presentation.products.presentation.addproduct.AddProductAction
import org.ninjaneers.motager.dashboard.presentation.products.presentation.addproduct.AddProductState

@Composable
fun Step3(
    state: AddProductState,
    coreState: CoreState,
    onAction: (AddProductAction) -> Unit,
) {
    val focusRequestManager = LocalFocusManager.current
    if (state.isAIDialogShown)
        AIDialog(
            language = coreState.language,
            onDismiss = { onAction(AddProductAction.OnAIDialogToggleVisibility) },
            openImagesDialog = { onAction(AddProductAction.OnImagesDialogToggleVisibility) }
        )
    if (state.isImagesDialogShown)
        ImagesDialog(
            language = coreState.language,
            onDismiss = { onAction(AddProductAction.OnImagesDialogToggleVisibility) },
            storeImage = { onAction(AddProductAction.OnProductImageStore(it)) },
        )
    Column(
        verticalArrangement = Arrangement.spacedBy(24.dp),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = stringResource(Res.string.SKU_Management),
                fontSize = 24.sp,
                fontFamily = FontFamily(
                    weight = FontWeight.Bold,
                    language = coreState.language
                ),
                color = MaterialTheme.colorScheme.onSurface
            )
            Button(
                modifier = Modifier.size(40.dp),
                onClick = { onAction(AddProductAction.OnAIDialogToggleVisibility) },
                shape = RoundedCornerShape(6.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.2f),
                    contentColor = MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.8f)
                ),
                contentPadding = PaddingValues(0.dp)
            ) {
                Icon(
                    imageVector = Lucide.Bot,
                    contentDescription = "Ai Assistant",
                    tint = MaterialTheme.colorScheme.primary
                )
            }
        }
        Column(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                text = stringResource(Res.string.Stock),
                fontSize = 14.sp,
                fontFamily = FontFamily(
                    weight = FontWeight.Medium,
                    language = coreState.language
                ),
                color = MaterialTheme.colorScheme.onSurface
            )
            PrimaryTextField(
                modifier = Modifier.fillMaxWidth(),
                value = state.stock,
                onValueChange = {
                    onAction(AddProductAction.OnProductStockChange(it))
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Next
                ),
                keyboardActions = KeyboardActions(
                    onNext = {
                        focusRequestManager.moveFocus(FocusDirection.Down)
                    }
                )
            )
        }
        Column(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                text = stringResource(Res.string.Price),
                fontSize = 14.sp,
                fontFamily = FontFamily(
                    weight = FontWeight.Medium,
                    language = coreState.language
                ),
                color = MaterialTheme.colorScheme.onSurface
            )
            PrimaryTextField(
                modifier = Modifier.fillMaxWidth(),
                value = state.price,
                onValueChange = {
                    onAction(AddProductAction.OnProductPriceChange(it))
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Next
                ),
                keyboardActions = KeyboardActions(
                    onNext = {
                        focusRequestManager.moveFocus(FocusDirection.Down)
                    }
                )
            )
        }
        Column(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                text = stringResource(Res.string.Compare_at_price),
                fontSize = 14.sp,
                fontFamily = FontFamily(
                    weight = FontWeight.Medium,
                    language = coreState.language
                ),
                color = MaterialTheme.colorScheme.onSurface
            )
            PrimaryTextField(
                modifier = Modifier
                    .fillMaxWidth(),
                value = state.comparePrice,
                onValueChange = {
                    onAction(AddProductAction.OnComparePriceChange(it))
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Next
                ),
                keyboardActions = KeyboardActions(
                    onNext = {
                        focusRequestManager.moveFocus(FocusDirection.Down)
                    }
                )
            )
        }
        Column(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                text = stringResource(Res.string.Profit),
                fontSize = 14.sp,
                fontFamily = FontFamily(
                    weight = FontWeight.Medium,
                    language = coreState.language
                ),
                color = MaterialTheme.colorScheme.onSurface
            )
            PrimaryTextField(
                modifier = Modifier
                    .fillMaxWidth(),
                value = state.profit,
                onValueChange = {
                    onAction(AddProductAction.OnProfitChange(it))
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Next
                ),
                keyboardActions = KeyboardActions(
                    onNext = {
                        focusRequestManager.moveFocus(FocusDirection.Down)
                    }
                )
            )
        }
        Column(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                text = stringResource(Res.string.Cost_per_item),
                fontSize = 14.sp,
                fontFamily = FontFamily(
                    weight = FontWeight.Medium,
                    language = coreState.language
                ),
                color = MaterialTheme.colorScheme.onSurface
            )
            PrimaryTextField(
                modifier = Modifier
                    .fillMaxWidth(),
                value = state.costPerItem,
                onValueChange = {
                    onAction(AddProductAction.OnCostPerItemChange(it))
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Next
                ),
                keyboardActions = KeyboardActions(
                    onNext = {
                        focusRequestManager.moveFocus(FocusDirection.Down)
                    }
                )
            )
        }
        Column(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                text = stringResource(Res.string.Margin),
                fontSize = 14.sp,
                fontFamily = FontFamily(
                    weight = FontWeight.Medium,
                    language = coreState.language
                ),
                color = MaterialTheme.colorScheme.onSurface
            )
            PrimaryTextField(
                modifier = Modifier
                    .fillMaxWidth(),
                value = state.margin,
                onValueChange = {
                    onAction(AddProductAction.OnMarginChange(it))
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Done
                ),
            )
        }
    }
}