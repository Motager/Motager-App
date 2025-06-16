package org.ninjaneers.motager.dashboard.presentation.products.presentation.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.composables.icons.lucide.Bot
import com.composables.icons.lucide.ChevronDown
import com.composables.icons.lucide.Image
import com.composables.icons.lucide.ImagePlus
import com.composables.icons.lucide.Lucide
import motager.composeapp.generated.resources.Add_images
import motager.composeapp.generated.resources.Basic_information
import motager.composeapp.generated.resources.Category
import motager.composeapp.generated.resources.Description
import motager.composeapp.generated.resources.Draft
import motager.composeapp.generated.resources.Enter_description
import motager.composeapp.generated.resources.Images
import motager.composeapp.generated.resources.No_Images
import motager.composeapp.generated.resources.Product_name
import motager.composeapp.generated.resources.Product_with_options
import motager.composeapp.generated.resources.Published
import motager.composeapp.generated.resources.Res
import motager.composeapp.generated.resources.Starting_price
import org.jetbrains.compose.resources.stringResource
import org.ninjaneers.motager.core.presentation.CoreState
import org.ninjaneers.motager.core.presentation.components.PrimarySwitch
import org.ninjaneers.motager.core.presentation.components.PrimaryTextField
import org.ninjaneers.motager.core.presentation.components.SecondaryButton
import org.ninjaneers.motager.core.presentation.theme.FontFamily
import org.ninjaneers.motager.dashboard.presentation.products.presentation.addproduct.AddProductAction
import org.ninjaneers.motager.dashboard.presentation.products.presentation.addproduct.AddProductState

@Composable
fun Step1(
    state: AddProductState,
    coreState: CoreState,
    onAction: (AddProductAction) -> Unit,
) {
    val animateRotation by animateFloatAsState(
        targetValue = if (state.isCategoryExpanded) 180f else 0f,
    )
    val focusRequestManager = LocalFocusManager.current
    if (state.isAIDialogShown)
        AiDescriptionDialog(
            state = state,
            language = coreState.language,
            onAction = onAction
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
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            PrimarySwitch(
                checked = state.product.isPublished,
                onCheckedChange = {
                    onAction(AddProductAction.OnProductPublishToggle)
                },
            )
            Text(
                text = stringResource(
                    if (state.product.isPublished)
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
                value = state.product.name,
                onValueChange = {
                    onAction(AddProductAction.OnProductNameChange(it))
                },
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
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
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
                    .heightIn(min = 100.dp),
                value = state.product.description,
                onValueChange = {
                    onAction(AddProductAction.OnProductDescriptionChange(it))
                },
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
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
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
                    .height(220.dp)
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
                    if (state.productImages.isEmpty()) {
                        Icon(
                            modifier = Modifier.padding(bottom = 8.dp),
                            imageVector = Lucide.Image,
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
                    } else {
                        LazyHorizontalGrid(
                            modifier = Modifier.fillMaxSize(),
                            rows = GridCells.Fixed(count = 2),
                            verticalArrangement = Arrangement.spacedBy(8.dp),
                            horizontalArrangement = Arrangement.spacedBy(8.dp),
                            contentPadding = PaddingValues(8.dp)
                        ) {
                            itemsIndexed(state.productImages) { index, image ->
                                ProductImage(
                                    modifier = Modifier.animateItem(),
                                    image = image,
                                    onImageDelete = {
                                        onAction(AddProductAction.OnProductImageDelete(index))
                                    }
                                )
                            }
                        }
                    }
                }
            }
            SecondaryButton(
                onClick = {
                    onAction(AddProductAction.OnImagesDialogToggleVisibility)
                },
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Icon(
                        modifier = Modifier.padding(end = 8.dp),
                        imageVector = Lucide.ImagePlus,
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
                Button(
                    modifier = Modifier
                        .fillMaxWidth(),
                    onClick = {
                        onAction(AddProductAction.OnCategoryMenuToggle)
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.background,
                        contentColor = MaterialTheme.colorScheme.onTertiary
                    ),
                    shape = RoundedCornerShape(8.dp),
                    contentPadding = PaddingValues(horizontal = 10.dp),
                    border = BorderStroke(
                        width = 0.8f.dp,
                        color = MaterialTheme.colorScheme.outline
                    )
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = if (state.product.category.id == 0) stringResource(Res.string.Category) else state.product.category.name,
                            fontSize = 16.sp,
                            fontFamily = FontFamily(
                                weight = FontWeight.Normal,
                                language = coreState.language
                            ),
                            color = MaterialTheme.colorScheme.onBackground
                        )
                        Icon(
                            modifier = Modifier.size(16.dp).rotate(animateRotation),
                            imageVector = Lucide.ChevronDown,
                            contentDescription = "Explore categories",
                            tint = MaterialTheme.colorScheme.onSurface
                        )
                    }
                }
                DropdownMenu(
                    modifier = Modifier.fillMaxWidth(0.72f).heightIn(max = 150.dp)
                        .clip(RoundedCornerShape(12.dp))
                        .border(width = 0.8f.dp, color = MaterialTheme.colorScheme.outline)
                        .background(MaterialTheme.colorScheme.background),
                    expanded = state.isCategoryExpanded,
                    onDismissRequest = {
                        onAction(AddProductAction.OnCategoryMenuToggle)
                    },
                    offset = DpOffset(x = 1.dp, y = 1.dp)
                ) {
                    repeat(state.categories.size) { index ->
                        DropdownMenuItem(
                            text = {
                                Text(
                                    text = state.categories[index].name,
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
                value = state.product.startPrice,
                onValueChange = {
                    onAction(AddProductAction.OnStartPriceChange(it))
                },
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
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Done
                )
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
                checked = state.hasVariants,
                onCheckedChange = {
                    onAction(AddProductAction.OnVariantSwitchToggle)
                }
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
    }
}