package org.ninjaneers.motager.dashboard.presentation.products.presentation.components

import androidx.compose.animation.animateContentSize
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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.composables.icons.lucide.CirclePlus
import com.composables.icons.lucide.Lucide
import com.mohamedrejeb.calf.core.LocalPlatformContext
import com.mohamedrejeb.calf.io.readByteArray
import com.mohamedrejeb.calf.picker.FilePickerFileType
import com.mohamedrejeb.calf.picker.FilePickerSelectionMode
import com.mohamedrejeb.calf.picker.rememberFilePickerLauncher
import kotlinx.coroutines.launch
import motager.composeapp.generated.resources.AI_description
import motager.composeapp.generated.resources.AI_information
import motager.composeapp.generated.resources.Apple
import motager.composeapp.generated.resources.Brand_name
import motager.composeapp.generated.resources.Choose_images
import motager.composeapp.generated.resources.Click_to_add_images
import motager.composeapp.generated.resources.Generate_product_info
import motager.composeapp.generated.resources.Product_images
import motager.composeapp.generated.resources.Res
import org.jetbrains.compose.resources.stringResource
import org.ninjaneers.motager.core.domain.Language
import org.ninjaneers.motager.core.presentation.components.PrimaryButton
import org.ninjaneers.motager.core.presentation.components.PrimaryTextField
import org.ninjaneers.motager.core.presentation.theme.FontFamily
import org.ninjaneers.motager.dashboard.presentation.products.presentation.addproduct.AddProductAction
import org.ninjaneers.motager.dashboard.presentation.products.presentation.addproduct.AddProductState

@Composable
fun AiDescriptionDialog(
    state: AddProductState,
    language: Language,
    onAction: (AddProductAction) -> Unit,
) {
    val context = LocalPlatformContext.current
    val scope = rememberCoroutineScope()
    val pickerLauncher = rememberFilePickerLauncher(
        type = FilePickerFileType.Image,
        selectionMode = FilePickerSelectionMode.Multiple,
        onResult = { images ->
            images.forEach { image ->
                scope.launch {
                    onAction(AddProductAction.OnAiImageStore(image.readByteArray(context)))
                }
            }
        }
    )
    Dialog(
        onDismissRequest = {
            onAction(AddProductAction.OnAIDialogToggleVisibility)
        },
        properties = DialogProperties(usePlatformDefaultWidth = false)
    ) {
        Card(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .fillMaxWidth(),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.background
            ),
            shape = RoundedCornerShape(8.dp),
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 18.dp, horizontal = 12.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    Text(
                        text = stringResource(Res.string.AI_information),
                        color = MaterialTheme.colorScheme.onBackground,
                        fontSize = 18.sp,
                        fontFamily = FontFamily(
                            language = language,
                            weight = FontWeight.SemiBold
                        )
                    )
                    Text(
                        text = stringResource(Res.string.AI_description),
                        color = MaterialTheme.colorScheme.onTertiary,
                        fontSize = 14.sp,
                        fontFamily = FontFamily(
                            language = language,
                            weight = FontWeight.Normal
                        ),
                        lineHeight = 16.sp,
                        textAlign = TextAlign.Center
                    )
                    Column(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalAlignment = Alignment.Start,
                    ) {
                        Text(
                            modifier = Modifier.padding(bottom = 8.dp),
                            text = stringResource(Res.string.Brand_name),
                            fontSize = 14.sp,
                            color = MaterialTheme.colorScheme.onBackground,
                            fontFamily = FontFamily(
                                language = language,
                                weight = FontWeight.Medium
                            ),
                        )
                        PrimaryTextField(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(42.dp),
                            value = state.brandName,
                            onValueChange = {
                                onAction(AddProductAction.OnBrandNameChange(it))
                            },
                            placeholder = {
                                Text(
                                    text = stringResource(Res.string.Apple),
                                    fontSize = 14.sp,
                                    color = MaterialTheme.colorScheme.surfaceVariant
                                )
                            }
                        )
                        Text(
                            modifier = Modifier.padding(top = 32.dp, bottom = 8.dp),
                            text = stringResource(Res.string.Product_images),
                            fontSize = 14.sp,
                            color = MaterialTheme.colorScheme.onBackground,
                            fontFamily = FontFamily(
                                language = language,
                                weight = FontWeight.Medium
                            ),
                        )
                        if (state.aiImages.isEmpty()) {
                            Button(
                                modifier = Modifier.padding(bottom = 4.dp),
                                onClick = {
                                    pickerLauncher.launch()
                                },
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = MaterialTheme.colorScheme.background,
                                    contentColor = MaterialTheme.colorScheme.onTertiary
                                ),
                                contentPadding = PaddingValues(0.dp),
                                shape = RoundedCornerShape(6.dp),
                                border = BorderStroke(
                                    width = 0.8f.dp,
                                    color = MaterialTheme.colorScheme.outline,
                                )
                            ) {
                                Column(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .background(MaterialTheme.colorScheme.background)
                                        .padding(vertical = 32.dp),
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    Icon(
                                        modifier = Modifier
                                            .size(32.dp)
                                            .padding(bottom = 8.dp),
                                        imageVector = Lucide.CirclePlus,
                                        contentDescription = "Add Images",
                                        tint = MaterialTheme.colorScheme.onTertiary
                                    )
                                    Text(
                                        text = stringResource(Res.string.Click_to_add_images),
                                        fontSize = 16.sp,
                                        fontFamily = FontFamily(
                                            language = language,
                                            weight = FontWeight.Normal
                                        ),
                                        color = MaterialTheme.colorScheme.onTertiary
                                    )
                                }
                            }
                        } else {
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
                                LazyHorizontalGrid(
                                    modifier = Modifier.fillMaxSize(),
                                    rows = GridCells.Fixed(count = 2),
                                    verticalArrangement = Arrangement.spacedBy(8.dp),
                                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                                    contentPadding = PaddingValues(8.dp)
                                ) {
                                    itemsIndexed(state.aiImages) { index, image ->
                                        ProductImage(
                                            modifier = Modifier.animateItem(),
                                            image = image,
                                            onImageDelete = {
                                                onAction(AddProductAction.OnAiImageDelete(index))
                                            }
                                        )
                                    }
                                    item {
                                        AddImageCard(onClick = { pickerLauncher.launch() })
                                    }
                                }
                            }
                        }
                    }
                    Text(
                        modifier = Modifier.padding(bottom = 32.dp),
                        text = stringResource(Res.string.Choose_images),
                        fontSize = 14.sp,
                        fontFamily = FontFamily(
                            language = language,
                            weight = FontWeight.Normal
                        ),
                        lineHeight = 16.sp,
                        color = MaterialTheme.colorScheme.onTertiary
                    )
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.End
                    ) {
                        PrimaryButton(
                            modifier = Modifier.height(40.dp).animateContentSize(),
                            onClick = {
                                onAction(
                                    AddProductAction.OnProductGenerateDescription(
                                        state.brandName,
                                        state.aiImagesUrls,
                                    )
                                )
                            },
                            shape = RoundedCornerShape(6.dp),
                            enabled = state.aiImages.isNotEmpty() && state.brandName.isNotEmpty()
                        ) {
                            if (!state.isGenerateDescriptionLoading) {
                                Text(
                                    text = stringResource(Res.string.Generate_product_info),
                                    fontFamily = FontFamily(
                                        language = language,
                                        weight = FontWeight.Normal
                                    ),
                                    color = MaterialTheme.colorScheme.onPrimary
                                )
                            } else {
                                CircularProgressIndicator(
                                    modifier = Modifier.size(24.dp),
                                    color = MaterialTheme.colorScheme.onPrimary
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}