package org.ninjaneers.motager.dashboard.presentation.products.presentation

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch
import motager.composeapp.generated.resources.Add_images
import motager.composeapp.generated.resources.Basic_information
import motager.composeapp.generated.resources.Category
import motager.composeapp.generated.resources.Description
import motager.composeapp.generated.resources.Draft
import motager.composeapp.generated.resources.Enter_description
import motager.composeapp.generated.resources.Images
import motager.composeapp.generated.resources.Next
import motager.composeapp.generated.resources.No_Images
import motager.composeapp.generated.resources.Previous
import motager.composeapp.generated.resources.Product_name
import motager.composeapp.generated.resources.Product_with_options
import motager.composeapp.generated.resources.Published
import motager.composeapp.generated.resources.Res
import motager.composeapp.generated.resources.Starting_price
import motager.composeapp.generated.resources.auth
import motager.composeapp.generated.resources.bot
import motager.composeapp.generated.resources.chevron_down
import motager.composeapp.generated.resources.chevronleft
import motager.composeapp.generated.resources.chevronright
import motager.composeapp.generated.resources.image
import motager.composeapp.generated.resources.image_plus
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.ninjaneers.motager.core.presentation.CoreState
import org.ninjaneers.motager.core.presentation.components.PrimaryButton
import org.ninjaneers.motager.core.presentation.components.PrimarySwitch
import org.ninjaneers.motager.core.presentation.components.PrimaryTextField
import org.ninjaneers.motager.core.presentation.components.SecondaryButton
import org.ninjaneers.motager.core.presentation.theme.FontFamily
import org.ninjaneers.motager.dashboard.domain.DashboardContent
import org.ninjaneers.motager.dashboard.presentation.DashboardAction

@Composable
fun AddProductScreen(
    state: AddProductState,
    coreState: CoreState,
    onAction: (AddProductAction) -> Unit,
    dashboardAction: suspend (DashboardAction) -> Unit
) {
    AddProductScreenContent(
        state = state,
        coreState = coreState,
        onAction = onAction,
        dashboardAction = dashboardAction
    )
}

@Composable
private fun AddProductScreenContent(
    state: AddProductState,
    coreState: CoreState,
    onAction: (AddProductAction) -> Unit,
    dashboardAction: suspend (DashboardAction) -> Unit
) {
    val coroutineScope = rememberCoroutineScope()
    val animateRotation by animateFloatAsState(
        targetValue = if (state.isCategoryExpanded) 180f else 0f,
    )
    Column(
        modifier = Modifier
            .clip(RoundedCornerShape(6.dp))
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.secondary.copy(alpha = 0.5f))
            .padding(8.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            userScrollEnabled = false
        ) {
            itemsIndexed(state.steps) { index, title ->
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                ) {
                    Box(
                        modifier = Modifier
                            .size(40.dp)
                            .clip(RoundedCornerShape(100.dp))
                            .background(MaterialTheme.colorScheme.primary),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = (index + 1).toString(),
                            fontSize = 14.sp,
                            fontFamily = FontFamily(
                                weight = FontWeight.Normal,
                                language = coreState.language
                            ),
                            color = MaterialTheme.colorScheme.onPrimary

                        )
                    }
                    Text(
                        text = stringResource(title),
                        fontSize = 14.sp,
                    )
                }
            }
        }
        Box(
            modifier = Modifier
                .padding(bottom = 32.dp)
                .fillMaxWidth()
                .height(4.dp)
                .clip(RoundedCornerShape(100.dp))
                .background(MaterialTheme.colorScheme.tertiary)
        )
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .clip(RoundedCornerShape(12.dp))
                .border(
                    width = 0.8f.dp,
                    color = MaterialTheme.colorScheme.outline,
                    shape = RoundedCornerShape(12.dp)
                ),
        ) {
            Image(
                painter = painterResource(Res.drawable.auth),
                contentDescription = null,
                contentScale = ContentScale.Crop,
            )
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .border(
                        width = 0.8f.dp,
                        shape = RoundedCornerShape(12.dp),
                        color = MaterialTheme.colorScheme.outline
                    )
                    .background(MaterialTheme.colorScheme.surface.copy(alpha = 0.9f))
                    .padding(24.dp),
                verticalArrangement = Arrangement.spacedBy(24.dp),
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = stringResource(Res.string.Basic_information),
                        fontSize = 24.sp,
                        fontFamily = FontFamily(
                            weight = FontWeight.Bold,
                            language = coreState.language
                        ),
                        color = MaterialTheme.colorScheme.onSurface
                    )
                    Button(
                        modifier = Modifier.size(40.dp),
                        onClick = {},
                        shape = RoundedCornerShape(6.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.2f),
                            contentColor = MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.8f)
                        ),
                        contentPadding = PaddingValues(0.dp)
                    ) {
                        Icon(
                            painter = painterResource(Res.drawable.bot),
                            contentDescription = "Ai Assistant",
                            tint = MaterialTheme.colorScheme.primary
                        )
                    }
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    PrimarySwitch(
                        checked = false,
                        onCheckedChange = {},
                    )
                    Text(
                        text = stringResource(
                            if (true)
                                Res.string.Published
                            else
                                Res.string.Draft
                        ),
                        fontSize = 14.sp,
                        fontFamily = FontFamily(
                            weight = FontWeight.Normal,
                            language = coreState.language
                        ),
                        color = MaterialTheme.colorScheme.onSurface
                    )
                }
                Column(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text(
                        text = stringResource(Res.string.Product_name),
                        fontSize = 14.sp,
                        fontFamily = FontFamily(
                            weight = FontWeight.Medium,
                            language = coreState.language
                        ),
                        color = MaterialTheme.colorScheme.onSurface
                    )
                    PrimaryTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = "",
                        onValueChange = {},
                        placeholder = {
                            Text(
                                text = stringResource(Res.string.Product_name),
                                fontSize = 16.sp,
                                fontFamily = FontFamily(
                                    weight = FontWeight.Normal,
                                    language = coreState.language
                                ),
                                color = MaterialTheme.colorScheme.surfaceVariant
                            )
                        }
                    )
                }
                Column(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text(
                        text = stringResource(Res.string.Description),
                        fontSize = 14.sp,
                        fontFamily = FontFamily(
                            weight = FontWeight.Medium,
                            language = coreState.language
                        ),
                        color = MaterialTheme.colorScheme.onSurface
                    )
                    PrimaryTextField(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp),
                        value = "",
                        onValueChange = {},
                        placeholder = {
                            Text(
                                text = stringResource(Res.string.Enter_description),
                                fontSize = 16.sp,
                                fontFamily = FontFamily(
                                    weight = FontWeight.Normal,
                                    language = coreState.language
                                ),
                                color = MaterialTheme.colorScheme.surfaceVariant
                            )
                        }
                    )
                }
                Column(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text(
                        text = stringResource(Res.string.Images),
                        fontSize = 14.sp,
                        fontFamily = FontFamily(
                            weight = FontWeight.Medium,
                            language = coreState.language
                        ),
                        color = MaterialTheme.colorScheme.onSurface
                    )
                    Box(
                        modifier = Modifier
                            .padding(bottom = 8.dp)
                            .fillMaxWidth()
                            .height(180.dp)
                            .clip(RoundedCornerShape(8.dp))
                            .border(
                                width = 0.8f.dp,
                                shape = RoundedCornerShape(8.dp),
                                color = (MaterialTheme.colorScheme.outline)
                            )
                            .background(MaterialTheme.colorScheme.background),
                        contentAlignment = Alignment.Center
                    ) {
                        Column(
                            modifier = Modifier.fillMaxSize(),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Icon(
                                modifier = Modifier.padding(bottom = 8.dp),
                                painter = painterResource(Res.drawable.image),
                                contentDescription = "Image",
                                tint = MaterialTheme.colorScheme.onTertiary
                            )
                            Text(
                                text = stringResource(Res.string.No_Images),
                                fontSize = 14.sp,
                                fontFamily = FontFamily(
                                    weight = FontWeight.Normal,
                                    language = coreState.language
                                ),
                                color = MaterialTheme.colorScheme.onSurface
                            )
                        }
                    }
                    SecondaryButton(
                        onClick = {}
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center
                        ) {
                            Icon(
                                modifier = Modifier.padding(end = 8.dp),
                                painter = painterResource(Res.drawable.image_plus),
                                contentDescription = "Add Image",
                                tint = MaterialTheme.colorScheme.onSurface
                            )
                            Text(
                                text = stringResource(Res.string.Add_images),
                                fontSize = 14.sp,
                                fontFamily = FontFamily(
                                    weight = FontWeight.Medium,
                                    language = coreState.language
                                ),
                                color = MaterialTheme.colorScheme.onSurface
                            )
                        }
                    }
                }
                Column(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text(
                        text = stringResource(Res.string.Category),
                        fontSize = 14.sp,
                        fontFamily = FontFamily(
                            weight = FontWeight.Medium,
                            language = coreState.language
                        ),
                        color = MaterialTheme.colorScheme.onSurface
                    )
                    Box(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        PrimaryTextField(
                            modifier = Modifier
                                .fillMaxWidth()
                                .onFocusChanged { focusState ->
                                    if (focusState.isFocused) {
                                        onAction(AddProductAction.OnCategoryMenuToggle)
                                    } else
                                        onAction(AddProductAction.OnCategoryMenuToggle)
                                },
                            value = if (state.productCategory != null) stringResource(state.productCategory) else "",
                            readOnly = true,
                            onValueChange = {},
                            trailingIcon = {
                                Icon(
                                    modifier = Modifier
                                        .rotate(animateRotation),
                                    painter = painterResource(Res.drawable.chevron_down),
                                    contentDescription = "Explore categories"
                                )
                            }
                        )
                        DropdownMenu(
                            modifier = Modifier.width(IntrinsicSize.Max).height(150.dp)
                                .clip(RoundedCornerShape(12.dp))
                                .border(width = 0.8f.dp, color = MaterialTheme.colorScheme.outline)
                                .background(MaterialTheme.colorScheme.background),
                            expanded = state.isCategoryExpanded,
                            onDismissRequest = {
                                onAction(AddProductAction.OnCategoryMenuToggle)
                            },
                            offset = DpOffset(x = 0.dp, y = (10).dp)
                        ) {
                            repeat(state.categories.size) { index ->
                                DropdownMenuItem(
                                    text = {
                                        Text(
                                            text = stringResource(state.categories[index]),
                                            fontSize = 14.sp,
                                            fontFamily = FontFamily(
                                                weight = FontWeight.Normal,
                                                language = coreState.language
                                            ),
                                            color = MaterialTheme.colorScheme.onSurface
                                        )
                                    },
                                    onClick = {
                                        onAction(AddProductAction.OnProductCategoryChange(state.categories[index]))
                                    }
                                )
                            }
                        }
                    }
                }
                Column(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text(
                        text = stringResource(Res.string.Starting_price),
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
                        value = "",
                        onValueChange = {},
                        placeholder = {
                            Text(
                                text = stringResource(Res.string.Starting_price),
                                fontSize = 16.sp,
                                fontFamily = FontFamily(
                                    weight = FontWeight.Normal,
                                    language = coreState.language
                                ),
                                color = MaterialTheme.colorScheme.surfaceVariant
                            )
                        }
                    )
                }
                HorizontalDivider(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(4.dp)
                        .clip(RoundedCornerShape(100.dp))
                        .background(MaterialTheme.colorScheme.tertiary)
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    PrimarySwitch(
                        checked = false,
                        onCheckedChange = {},
                    )
                    Text(
                        text = stringResource(Res.string.Product_with_options),
                        fontSize = 14.sp,
                        fontFamily = FontFamily(
                            weight = FontWeight.Medium,
                            language = coreState.language
                        ),
                        color = MaterialTheme.colorScheme.onSurface
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth().padding(top = 24.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    SecondaryButton(
                        onClick = {
                            if (state.currentStep == 1) {
                                coroutineScope.launch {
                                    dashboardAction(
                                        DashboardAction.OnContentChange(
                                            content = DashboardContent.Products
                                        )
                                    )
                                }
                            } else {
                                onAction(AddProductAction.OnStepChange(state.currentStep - 1))
                            }
                        }
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center
                        ) {
                            Icon(
                                modifier = Modifier.padding(end = 8.dp),
                                painter = painterResource(Res.drawable.chevronleft),
                                contentDescription = "Previous",
                                tint = MaterialTheme.colorScheme.onSurface
                            )
                            Text(
                                text = stringResource(Res.string.Previous),
                                fontSize = 14.sp,
                                fontFamily = FontFamily(
                                    weight = FontWeight.Medium,
                                    language = coreState.language
                                ),
                                color = MaterialTheme.colorScheme.onSurface
                            )
                        }
                    }
                    PrimaryButton(
                        onClick = {},
                        shape = RoundedCornerShape(6.dp)
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            Text(
                                text = stringResource(Res.string.Next),
                                fontSize = 14.sp,
                                fontFamily = FontFamily(
                                    weight = FontWeight.Medium,
                                    language = coreState.language
                                ),
                                color = MaterialTheme.colorScheme.onPrimary
                            )
                            Icon(
                                painter = painterResource(Res.drawable.chevronright),
                                contentDescription = "Next",
                                tint = MaterialTheme.colorScheme.onPrimary
                            )
                        }
                    }

                }
            }
        }
    }
}
