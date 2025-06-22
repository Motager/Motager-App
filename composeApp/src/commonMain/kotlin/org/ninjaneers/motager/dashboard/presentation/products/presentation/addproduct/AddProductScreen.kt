package org.ninjaneers.motager.dashboard.presentation.products.presentation.addproduct

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.composables.icons.lucide.ChevronLeft
import com.composables.icons.lucide.ChevronRight
import com.composables.icons.lucide.Lucide
import kotlinx.coroutines.launch
import motager.composeapp.generated.resources.Next
import motager.composeapp.generated.resources.Previous
import motager.composeapp.generated.resources.Res
import motager.composeapp.generated.resources.Submit_product
import motager.composeapp.generated.resources.auth
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.ninjaneers.motager.core.domain.Language
import org.ninjaneers.motager.core.presentation.CoreState
import org.ninjaneers.motager.core.presentation.components.PrimaryButton
import org.ninjaneers.motager.core.presentation.components.SecondaryButton
import org.ninjaneers.motager.core.presentation.theme.FontFamily
import org.ninjaneers.motager.dashboard.domain.DashboardContent
import org.ninjaneers.motager.dashboard.presentation.DashboardAction
import org.ninjaneers.motager.dashboard.presentation.products.presentation.components.Step1
import org.ninjaneers.motager.dashboard.presentation.products.presentation.components.Step2
import org.ninjaneers.motager.dashboard.presentation.products.presentation.components.Step3
import org.ninjaneers.motager.dashboard.presentation.products.presentation.components.Step4

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
    LaunchedEffect(Unit) {
        onAction(AddProductAction.OnStoreCategoriesGet(coreState.store.id))
    }
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
                            .background(
                                if (state.currentStep >= index + 1)
                                    MaterialTheme.colorScheme.primary
                                else
                                    MaterialTheme.colorScheme.tertiary
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = if (index + 1 < state.currentStep) "✓" else (index + 1).toString(),
                            fontSize = 14.sp,
                            fontFamily = FontFamily(
                                weight = FontWeight.Normal,
                                language = coreState.language
                            ),
                            color = if (index + 1 <= state.currentStep)
                                MaterialTheme.colorScheme.onPrimary
                            else
                                MaterialTheme.colorScheme.onTertiary

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
                AnimatedContent(
                    targetState = state.currentStep
                ) { step ->
                    when (step) {
                        1 -> Step1(
                            state = state,
                            coreState = coreState,
                            onAction = onAction,
                        )

                        2 -> {
                            if (state.hasVariants) {
                                Step2(
                                    state = state,
                                    coreState = coreState,
                                    onAction = onAction,
                                )
                            } else {
                                Step3( // SKUs
                                    state = state,
                                    coreState = coreState,
                                    onAction = onAction,
                                )
                            }
                        }
                        3 -> {
                            if (state.hasVariants) {
                                Step3(
                                    state = state,
                                    coreState = coreState,
                                    onAction = onAction,
                                )
                            } else {
                                Step4( // SKUs
                                    state = state,
                                    coreState = coreState,
                                    onAction = onAction,
                                )
                            }
                        }
                        4 -> {
                            if (state.hasVariants) {
                                Step4( // SKUs
                                    state = state,
                                    coreState = coreState,
                                    onAction = onAction,
                                )
                            }
                        }

                        else -> {}
                    }
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
                                onAction(AddProductAction.OnStepBack)
                            }
                        }
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center
                        ) {
                            Icon(
                                modifier = Modifier.padding(end = 8.dp),
                                imageVector = if (coreState.language == Language.English) Lucide.ChevronLeft else Lucide.ChevronRight,
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
                    val isLastStep = if (state.hasVariants) {
                        state.currentStep == 4
                    } else {
                        state.currentStep == 3
                    }
                    PrimaryButton(
                        modifier = Modifier.animateContentSize(),
                        onClick = {
                            if (!isLastStep) {
                                onAction(AddProductAction.OnStepChange(state.currentStep))
                            } else {
                                onAction(AddProductAction.OnProductCreate(coreState.store.id))
                            }
                        },
                        shape = RoundedCornerShape(6.dp),
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            if (!state.isUploadProductLoading) {
                                Text(
                                    text = if (isLastStep)
                                        stringResource(Res.string.Submit_product)
                                    else
                                        stringResource(Res.string.Next),
                                    fontSize = 14.sp,
                                    fontFamily = FontFamily(
                                        weight = FontWeight.Medium,
                                        language = coreState.language
                                    ),
                                    color = MaterialTheme.colorScheme.onPrimary
                                )
                                Icon(
                                    imageVector = if (coreState.language == Language.English) Lucide.ChevronRight else Lucide.ChevronLeft,
                                    contentDescription = if (isLastStep) "Submit" else "Next",
                                    tint = MaterialTheme.colorScheme.onPrimary
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
